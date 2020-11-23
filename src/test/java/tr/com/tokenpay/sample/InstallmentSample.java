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
    void retrieve_bin() {
        String binNumber = "525864";

        BinNumberResponse response = tokenPay.installment().retrieveBinNumber(binNumber);
        assertEquals(response.getBinNumber(), binNumber);
        assertEquals(response.getCardType(), CardType.CREDIT_CARD);
        assertEquals(response.getCardAssociation(), CardAssociation.MASTER_CARD);
        assertEquals(response.getCardBrand(), "World");
        assertEquals(response.getBankName(), "YAPI VE KREDİ BANKASI A.Ş.");
        assertEquals(response.getBankCode(), 67L);
        assertEquals(response.getCommercial(), false);
    }

    @Test
    void search_installments() {
        SearchInstallmentsRequest request = SearchInstallmentsRequest.builder()
                .binNumber("525864")
                .price(BigDecimal.valueOf(100L))
                .currency(Currency.TRY)
                .build();

        InstallmentListResponse response = tokenPay.installment().searchInstallments(request);
        assertTrue(response.getItems().size() > 0);
    }
}
