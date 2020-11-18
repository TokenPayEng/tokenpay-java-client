package tr.com.tokenpay.adapter;

import tr.com.tokenpay.net.HttpClient;
import tr.com.tokenpay.request.SearchPaymentsRequest;
import tr.com.tokenpay.request.common.RequestOptions;
import tr.com.tokenpay.request.common.RequestQueryParamsBuilder;
import tr.com.tokenpay.response.PaymentDetailListResponse;
import tr.com.tokenpay.response.PaymentDetailResponse;

public class PaymentReportingAdapter extends BaseAdapter {

    public PaymentReportingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PaymentDetailResponse retrievePayment(Long id) {
        String path = "/payment-reporting/v1/payments/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentDetailResponse.class);
    }

    public PaymentDetailListResponse searchPayments(SearchPaymentsRequest searchPaymentsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPaymentsRequest);
        String path = "/payment-reporting/v1/payments" + query;

        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentDetailListResponse.class);
    }
}
