package tr.com.tokenpay.adapter;

import tr.com.tokenpay.net.HttpClient;
import tr.com.tokenpay.request.CreateLinkRequest;
import tr.com.tokenpay.request.SearchLinksRequest;
import tr.com.tokenpay.request.UpdateLinkRequest;
import tr.com.tokenpay.request.common.RequestOptions;
import tr.com.tokenpay.request.common.RequestQueryParamsBuilder;
import tr.com.tokenpay.response.LinkListResponse;
import tr.com.tokenpay.response.LinkResponse;

public class LinkAdapter extends BaseAdapter {

    public LinkAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public LinkResponse createLink(CreateLinkRequest createLinkRequest) {
        String path = "/tokenlink/v1/products";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createLinkRequest, path, requestOptions), createLinkRequest, LinkResponse.class);
    }

    public LinkResponse updateLink(Long id, UpdateLinkRequest updateLinkRequest) {
        String path = "/tokenlink/v1/products/" + id;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateLinkRequest, path, requestOptions), updateLinkRequest, LinkResponse.class);
    }

    public LinkResponse retrieve(Long id) {
        String path = "/tokenlink/v1/products/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), LinkResponse.class);
    }

    public LinkListResponse search(SearchLinksRequest searchLinksRequest) {
        String params = RequestQueryParamsBuilder.buildQueryParam(searchLinksRequest);
        String path = "/tokenlink/v1/products?" + params;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), LinkListResponse.class);
    }

    public void delete(Long id) {
        String path = "/tokenlink/v1/products/" + id;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), Void.class);
    }
}
