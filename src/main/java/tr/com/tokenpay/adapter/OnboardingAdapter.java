package tr.com.tokenpay.adapter;

import tr.com.tokenpay.net.HttpClient;
import tr.com.tokenpay.request.*;
import tr.com.tokenpay.request.common.RequestOptions;
import tr.com.tokenpay.request.common.RequestQueryParamsBuilder;
import tr.com.tokenpay.response.BuyerResponse;
import tr.com.tokenpay.response.SubMerchantListResponse;
import tr.com.tokenpay.response.SubMerchantResponse;

public class OnboardingAdapter extends BaseAdapter {

    public OnboardingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public SubMerchantResponse createSubMerchant(CreateSubMerchantRequest createSubMerchantRequest) {
        String path = "/onboarding/v1/sub-merchants";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createSubMerchantRequest, path, requestOptions),
                createSubMerchantRequest, SubMerchantResponse.class);
    }

    public SubMerchantResponse updateSubMerchant(Long id, UpdateSubMerchantRequest updateSubMerchantRequest) {
        String path = "/onboarding/v1/sub-merchants/" + id;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateSubMerchantRequest, path, requestOptions),
                updateSubMerchantRequest, SubMerchantResponse.class);
    }

    public SubMerchantResponse retrieveSubMerchant(Long id) {
        String path = "/onboarding/v1/sub-merchants/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), SubMerchantResponse.class);
    }

    public SubMerchantListResponse searchSubMerchants(SearchSubMerchantsRequest searchSubMerchantsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchSubMerchantsRequest);
        String path = "/onboarding/v1/sub-merchants" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), SubMerchantListResponse.class);
    }

    public BuyerResponse createBuyer(CreateBuyerRequest createBuyerRequest) {
        String path = "/onboarding/v1/buyers";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createBuyerRequest, path, requestOptions),
                createBuyerRequest, BuyerResponse.class);
    }

    public BuyerResponse updateBuyer(Long id, UpdateBuyerRequest updateBuyerRequest) {
        String path = "/onboarding/v1/buyers/" + id;
        return HttpClient.put(requestOptions.getBaseUrl() + path, createHeaders(updateBuyerRequest, path, requestOptions),
                updateBuyerRequest, BuyerResponse.class);
    }

    public BuyerResponse retrieveBuyer(Long id) {
        String path = "/onboarding/v1/buyers/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), BuyerResponse.class);
    }
}