package tr.com.tokenpay.adapter;

import tr.com.tokenpay.net.HttpClient;
import tr.com.tokenpay.request.SearchBouncedSubMerchantRowsRequest;
import tr.com.tokenpay.request.SearchPayoutCompletedTransactionsRequest;
import tr.com.tokenpay.request.common.RequestOptions;
import tr.com.tokenpay.request.common.RequestQueryParamsBuilder;
import tr.com.tokenpay.response.BouncedSubMerchantRowListResponse;
import tr.com.tokenpay.response.PayoutCompletedTransactionListResponse;

public class SettlementReportingAdapter extends BaseAdapter {

    public SettlementReportingAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public BouncedSubMerchantRowListResponse searchBouncedSubMerchantRows(SearchBouncedSubMerchantRowsRequest searchBouncedSubMerchantRowsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchBouncedSubMerchantRowsRequest);
        String path = "/settlement-reporting/v1/settlement-file/bounced-sub-merchant-rows" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), BouncedSubMerchantRowListResponse.class);
    }

    public PayoutCompletedTransactionListResponse searchPayoutCompletedTransactions(SearchPayoutCompletedTransactionsRequest searchPayoutCompletedTransactionsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPayoutCompletedTransactionsRequest);
        String path = "/settlement-reporting/v1/settlement-file/payout-completed-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PayoutCompletedTransactionListResponse.class);
    }
}