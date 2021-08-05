package tr.com.tokenpay.request.common;

import com.google.gson.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import tr.com.tokenpay.exception.TokenPayException;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class HashGenerator {

    private HashGenerator() {
    }

    public static String generateHash(String baseUrl, String apiKey, String secretKey, String randomString, Request request, String path) {
        try {
            String hashData = "";
            String decodedUrl = URLDecoder.decode(baseUrl + path, StandardCharsets.UTF_8.toString());

            if (request != null) {
                Gson gson = buildGson();
                String requestBody = gson.toJson(request);
                hashData = decodedUrl + apiKey + secretKey + randomString + requestBody;
            } else {
                hashData = decodedUrl + apiKey + secretKey + randomString;
            }

            return Base64.encodeBase64String(DigestUtils.sha256(hashData));
        } catch (Exception e) {
            throw new TokenPayException(e);
        }
    }

    private static Gson buildGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime.parse(json.getAsString()))
                .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (json, typeOfT, context) -> new JsonPrimitive(json.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .create();
    }
}
