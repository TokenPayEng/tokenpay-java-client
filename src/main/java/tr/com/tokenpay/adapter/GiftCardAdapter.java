package tr.com.tokenpay.adapter;

import tr.com.tokenpay.net.HttpClient;
import tr.com.tokenpay.request.GiftCardBalanceRequest;
import tr.com.tokenpay.request.common.RequestOptions;
import tr.com.tokenpay.request.common.RequestQueryParamsBuilder;
import tr.com.tokenpay.response.GiftCardBalanceResponse;

public class GiftCardAdapter extends BaseAdapter {

    public GiftCardAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public GiftCardBalanceResponse retrieveBalance(GiftCardBalanceRequest request) {
        String query = RequestQueryParamsBuilder.buildQueryParam(request);
        String path = "/payment/v1/gift-cards/balance" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), GiftCardBalanceResponse.class);
    }

    public GiftCardBalanceResponse quoteBalance(GiftCardBalanceRequest request) {
        String path = "/payment/v1/gift-cards/balance/quote";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(request, path, requestOptions),
                request, GiftCardBalanceResponse.class);
    }

}
