package tr.com.tokenpay.sample;

import org.junit.jupiter.api.Test;
import tr.com.tokenpay.TokenPay;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.model.PaymentStatus;
import tr.com.tokenpay.request.SearchPaymentsRequest;
import tr.com.tokenpay.response.PaymentDetailListResponse;
import tr.com.tokenpay.response.PaymentDetailResponse;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentReportingSample {

    private final TokenPay tokenPay = new TokenPay("api-key", "secret-key", "http://localhost:8000");

    @Test
    void retrieve_payment_sample() {
        Long paymentId = 1L;

        PaymentDetailResponse paymentResponse = tokenPay.paymentReporting().retrievePayment(paymentId);
        assertNotNull(paymentResponse);
        assertEquals(paymentResponse.getId(), paymentId);
    }

    @Test
    void search_payment_sample() {
        SearchPaymentsRequest request = SearchPaymentsRequest.builder()
                .currency(Currency.TRY)
                .paymentStatus(PaymentStatus.SUCCESS)
                .build();

        PaymentDetailListResponse paymentDetailListResponse = tokenPay.paymentReporting().searchPayments(request);
        assertNotNull(paymentDetailListResponse);
        assertTrue(paymentDetailListResponse.getItems().size() > 0);
    }
}
