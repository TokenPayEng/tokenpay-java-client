package tr.com.tokenpay.adapter;

import tr.com.tokenpay.net.HttpClient;
import tr.com.tokenpay.request.*;
import tr.com.tokenpay.request.common.RequestOptions;
import tr.com.tokenpay.request.common.RequestQueryParamsBuilder;
import tr.com.tokenpay.response.*;

public class PaymentAdapter extends BaseAdapter {

    public PaymentAdapter(RequestOptions requestOptions) {
        super(requestOptions);
    }

    public PaymentResponse createPayment(CreatePaymentRequest createPaymentRequest) {
        String path = "/payment/v1/card-payments";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(createPaymentRequest, path, requestOptions),
                createPaymentRequest, PaymentResponse.class);
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

    public PaymentTransactionApprovalListResponse approvePaymentTransactions(ApprovePaymentTransactionsRequest approvePaymentTransactionsRequest) {
        String path = "/payment/v1/payment-transactions/approve";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(approvePaymentTransactionsRequest, path, requestOptions),
                approvePaymentTransactionsRequest, PaymentTransactionApprovalListResponse.class);
    }

    public PaymentTransactionApprovalListResponse disapprovePaymentTransactions(DisapprovePaymentTransactionsRequest disapprovePaymentTransactionsRequest) {
        String path = "/payment/v1/payment-transactions/disapprove";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(disapprovePaymentTransactionsRequest, path, requestOptions),
                disapprovePaymentTransactionsRequest, PaymentTransactionApprovalListResponse.class);
    }

    public InitThreeDSPaymentResponse init3DSPayment(InitThreeDSPaymentRequest initThreeDSPaymentRequest) {
        String path = "/payment/v1/card-payments/3ds-init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initThreeDSPaymentRequest, path, requestOptions),
                initThreeDSPaymentRequest, InitThreeDSPaymentResponse.class);
    }

    public PaymentResponse complete3DSPayment(CompleteThreeDSPaymentRequest completeThreeDSPaymentRequest) {
        String path = "/payment/v1/card-payments/3ds-complete";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(completeThreeDSPaymentRequest, path, requestOptions),
                completeThreeDSPaymentRequest, PaymentResponse.class);
    }

    public InitCheckoutPaymentResponse initCheckoutPayment(InitCheckoutPaymentRequest initCheckoutPaymentRequest) {
        String path = "/payment/v1/checkout-payment/init";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(initCheckoutPaymentRequest, path, requestOptions),
                initCheckoutPaymentRequest, InitCheckoutPaymentResponse.class);
    }

    public PaymentResponse retrieveCheckoutPayment(String token) {
        String path = "/payment/v1/checkout-payment?token=" + token;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentResponse.class);
    }

    public PaymentTransactionRefundResponse refundPaymentTransaction(RefundPaymentTransactionRequest refundPaymentTransactionRequest) {
        String path = "/payment/v1/refund-transactions";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentTransactionRequest, path, requestOptions),
                refundPaymentTransactionRequest, PaymentTransactionRefundResponse.class);
    }

    public PaymentTransactionRefundResponse retrievePaymentTransactionRefund(Long id) {
        String path = "/payment/v1/refund-transactions/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTransactionRefundResponse.class);
    }

    public PaymentTransactionRefundListResponse searchPaymentTransactionRefunds(SearchPaymentTransactionRefundsRequest searchPaymentTransactionRefundsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchPaymentTransactionRefundsRequest);
        String path = "/payment/v1/refund-transactions" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentTransactionRefundListResponse.class);
    }

    public PaymentRefundResponse refundPayment(RefundPaymentRequest refundPaymentRequest) {
        String path = "/payment/v1/refunds";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(refundPaymentRequest, path, requestOptions),
                refundPaymentRequest, PaymentRefundResponse.class);
    }

    public PaymentRefundResponse retrievePaymentRefund(Long id) {
        String path = "/payment/v1/refunds/" + id;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), PaymentRefundResponse.class);
    }

    public CrossBookingTransactionResponse receiveMoney(CrossBookingRequest crossBookingRequest) {
        String path = "/payment/v1/cross-bookings/receive";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(crossBookingRequest, path, requestOptions),
                crossBookingRequest, CrossBookingTransactionResponse.class);
    }

    public CrossBookingTransactionResponse sendMoney(CrossBookingRequest crossBookingRequest) {
        String path = "/payment/v1/cross-bookings/send";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(crossBookingRequest, path, requestOptions),
                crossBookingRequest, CrossBookingTransactionResponse.class);
    }

    public CrossBookingTransactionResponse cancelCrossBooking(CancelCrossBookingRequest cancelCrossBookingRequest) {
        String path = "/payment/v1/cross-bookings/cancel";
        return HttpClient.post(requestOptions.getBaseUrl() + path, createHeaders(cancelCrossBookingRequest, path, requestOptions),
                cancelCrossBookingRequest, CrossBookingTransactionResponse.class);
    }

    public CrossBookingTransactionListResponse searchCrossBookings(SearchCrossBookingsRequest searchCrossBookingsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchCrossBookingsRequest);
        String path = "/payment/v1/cross-bookings" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), CrossBookingTransactionListResponse.class);
    }

    public void deleteStoredCard(DeleteStoredCardRequest deleteStoredCardRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(deleteStoredCardRequest);
        String path = "/payment/v1/cards" + query;
        HttpClient.delete(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), Void.class);
    }

    public StoredCardListResponse searchStoredCards(SearchStoredCardsRequest searchStoredCardsRequest) {
        String query = RequestQueryParamsBuilder.buildQueryParam(searchStoredCardsRequest);
        String path = "/payment/v1/cards" + query;
        return HttpClient.get(requestOptions.getBaseUrl() + path, createHeaders(path, requestOptions), StoredCardListResponse.class);
    }
}
