package com.tokenpay.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tokenpay.exception.HttpClientException;
import com.tokenpay.response.common.Response;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.tokenpay.net.HttpMethod.*;

public class HttpClient {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCEPT = "Accept";
    private static final int TIMEOUT = 140000;
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    private HttpClient() {
    }

    public static <T> T get(String url, Class<T> responseType) {
        return exchange(url, GET, new HashMap<>(), null, responseType);
    }

    public static <T> T get(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, GET, headers, request, responseType);
    }

    public static <T> T post(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, POST, headers, request, responseType);
    }

    public static <T> T put(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, PUT, headers, request, responseType);
    }

    public static <T> T delete(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        return exchange(url, DELETE, headers, request, responseType);
    }

    private static <T> T exchange(String url, HttpMethod httpMethod, Map<String, String> headers, Object request, Class<T> responseType) {
        String body = gson.toJson(request);
        try {
            InputStream content = request == null ? null : new ByteArrayInputStream(body.getBytes(DEFAULT_CHARSET));
            String responseBody = send(url, httpMethod, content, headers);
            Response response = gson.fromJson(responseBody, Response.class);
            // TODO handle errors

            if (responseType == Void.class) {
                return null;
            }

            return gson.fromJson(response.getData(), responseType);
        } catch (UnsupportedEncodingException e) {
            throw new HttpClientException(e.getMessage(), e);
        }
    }

    private static String send(String url, HttpMethod httpMethod, InputStream content, Map<String, String> headers) {
        URLConnection raw;
        HttpURLConnection conn = null;
        try {
            raw = new URL(url).openConnection();
            conn = (HttpURLConnection) raw;

//            conn.setSSLSocketFactory(socketFactory);
            conn.setRequestMethod(httpMethod.name());

            conn.setConnectTimeout(TIMEOUT);
            conn.setReadTimeout(TIMEOUT);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);

            prepareHeaders(headers, conn);
            if (content != null) {
                prepareRequestBody(httpMethod, content, conn);
            }

            return new String(body(conn), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new HttpClientException(e.getMessage(), e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static void prepareHeaders(Map<String, String> headers, HttpURLConnection conn) {
        for (Map.Entry<String, String> header : headers.entrySet()) {
            conn.addRequestProperty(header.getKey(), header.getValue());
        }

        conn.addRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
        conn.addRequestProperty(ACCEPT, APPLICATION_JSON);
    }

    private static void prepareRequestBody(HttpMethod httpMethod, InputStream content, HttpURLConnection conn) throws IOException {
        if (HttpMethod.hasBody(httpMethod)) {
            conn.setDoOutput(true);
            final OutputStream output = conn.getOutputStream();
            try {
                prepareOutputStream(content, output);
            } finally {
                output.close();
                content.close();
            }
        }
    }

    private static void prepareOutputStream(InputStream content, OutputStream output) throws IOException {
        final byte[] buffer = new byte[8192];
        for (int bytes = content.read(buffer); bytes != -1;
             bytes = content.read(buffer)) {
            output.write(buffer, 0, bytes);
        }
    }

    private static byte[] body(HttpURLConnection conn) throws IOException {
        final InputStream input;
        if (conn.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
            input = conn.getErrorStream();
        } else {
            input = conn.getInputStream();
        }
        final byte[] body;
        if (input == null) {
            body = new byte[0];
        } else {
            try {

                final byte[] buffer = new byte[8192];
                final ByteArrayOutputStream output = new ByteArrayOutputStream();
                for (int bytes = input.read(buffer); bytes != -1;
                     bytes = input.read(buffer)) {
                    output.write(buffer, 0, bytes);
                }
                body = output.toByteArray();
            } finally {
                input.close();
            }
        }
        return body;
    }
}
