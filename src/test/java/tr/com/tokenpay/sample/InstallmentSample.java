package tr.com.tokenpay.sample;

import org.junit.jupiter.api.Test;
import tr.com.tokenpay.TokenPay;
import tr.com.tokenpay.model.CardAssociation;
import tr.com.tokenpay.model.CardType;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.request.SearchInstallmentsRequest;
import tr.com.tokenpay.response.BinNumberResponse;
import tr.com.tokenpay.response.InstallmentListResponse;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstallmentSample {

    private final TokenPay tokenPay = new TokenPay("api-key", "secret-key", "http://localhost:8000");

    @Test
    void search_installments_sample() {
        SearchInstallmentsRequest request = SearchInstallmentsRequest.builder()
                .binNumber("525864")
                .price(BigDecimal.valueOf(100L))
                .currency(Currency.TRY)
                .build();

        InstallmentListResponse installmentListResponse = tokenPay.installment().searchInstallments(request);
        assertTrue(installmentListResponse.getItems().size() > 0);
    }

    @Test
    void retrieve_bin_sample() {
        String binNumber = "525864";

        BinNumberResponse binNumberResponse = tokenPay.installment().retrieveBinNumber(binNumber);
        assertEquals(binNumberResponse.getBinNumber(), binNumber);
        assertEquals(binNumberResponse.getCardType(), CardType.CREDIT_CARD);
        assertEquals(binNumberResponse.getCardAssociation(), CardAssociation.MASTER_CARD);
        assertEquals(binNumberResponse.getCardBrand(), "World");
        assertEquals(binNumberResponse.getBankName(), "YAPI VE KREDİ BANKASI A.Ş.");
        assertEquals(binNumberResponse.getBankCode(), 67L);
        assertEquals(binNumberResponse.getCommercial(), false);
    }
}
