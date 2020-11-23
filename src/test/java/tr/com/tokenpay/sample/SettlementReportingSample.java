package tr.com.tokenpay.sample;

import org.junit.jupiter.api.Test;
import tr.com.tokenpay.TokenPay;
import tr.com.tokenpay.model.SettlementType;
import tr.com.tokenpay.request.SearchBouncedSubMerchantRowsRequest;
import tr.com.tokenpay.request.SearchPayoutCompletedTransactionsRequest;
import tr.com.tokenpay.response.BouncedSubMerchantRowListResponse;
import tr.com.tokenpay.response.PayoutCompletedTransactionListResponse;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SettlementReportingSample {

    private final TokenPay tokenPay = new TokenPay("api-key", "secret-key", "http://localhost:8000");

    @Test
    void search_bounced_sub_merchant_rows() {
        SearchBouncedSubMerchantRowsRequest request = SearchBouncedSubMerchantRowsRequest.builder()
                .startDate(LocalDateTime.now().minusDays(10))
                .endDate(LocalDateTime.now())
                .build();

        BouncedSubMerchantRowListResponse response = tokenPay.settlementReporting().searchBouncedSubMerchantRows(request);
        assertNotNull(response);
    }

    @Test
    void search_payout_completed_transactions() {
        SearchPayoutCompletedTransactionsRequest request = SearchPayoutCompletedTransactionsRequest.builder()
                .startDate(LocalDateTime.now().minusDays(10))
                .endDate(LocalDateTime.now())
                .settlementFileId(1L)
                .settlementType(SettlementType.SETTLEMENT)
                .build();

        PayoutCompletedTransactionListResponse response = tokenPay.settlementReporting().searchPayoutCompletedTransactions(request);
        assertNotNull(response);
    }
}
