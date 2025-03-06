package tr.com.tokenpay.adapter;

import tr.com.tokenpay.net.HttpClient;
import tr.com.tokenpay.request.SearchInstallmentsInDetailRequest;
import tr.com.tokenpay.request.SearchInstallmentsRequest;
import tr.com.tokenpay.request.common.RequestOptions;
import tr.com.tokenpay.request.common.RequestQueryParamsBuilder;
import tr.com.tokenpay.response.BinNumberResponse;
import tr.com.tokenpay.response.InstallmentListResponse;

public class InstallmentAdapter extends BaseAdapter {

    public InstallmentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public InstallmentListResponse searchInstallments(SearchInstallmentsRequest searchInstallmentsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchInstallmentsRequest);
        String path = "/installment/v1/installments" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), InstallmentListResponse.class);
    }

    public InstallmentListResponse searchInstallmentsInDetail(SearchInstallmentsInDetailRequest searchInstallmentsInDetailRequest) {
        String path = "/installment/v1/installments/retrieve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(searchInstallmentsInDetailRequest, path, requestOptions),searchInstallmentsInDetailRequest, InstallmentListResponse.class);
    }

    public BinNumberResponse retrieveBinNumber(String binNumber) {
        String path = "/installment/v1/bins/" + binNumber;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), BinNumberResponse.class);
    }
}
