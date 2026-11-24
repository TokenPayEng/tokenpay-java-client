package tr.com.tokenpay;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import tr.com.tokenpay.model.GiftCardBalanceBucketStatus;
import tr.com.tokenpay.model.GiftCardRefundStatus;
import tr.com.tokenpay.model.GiftCardType;
import tr.com.tokenpay.net.HttpClient;
import tr.com.tokenpay.request.InitThreeDSPaymentRequest;
import tr.com.tokenpay.response.GiftCardBalanceResponse;
import tr.com.tokenpay.response.PaymentTransactionRefundResponse;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiftCardContractTest {

    @Test
    void shouldSerializeGiftCardPaymentInThreeDSInitRequest() throws Exception {
        InitThreeDSPaymentRequest request = InitThreeDSPaymentRequest.builder()
                .giftCardUserId("905001112233")
                .giftCardPrice(new BigDecimal("500.00"))
                .build();

        String json = gson().toJson(request);

        assertEquals("905001112233", gson().fromJson(json, InitThreeDSPaymentRequest.class)
                .getGiftCardUserId());
        assertEquals(new BigDecimal("500.00"), gson().fromJson(json, InitThreeDSPaymentRequest.class)
                .getGiftCardPrice());
    }

    @Test
    void shouldDeserializeGiftCardDetailsAndExpiryDate() throws Exception {
        String json = """
                {
                  "spaceId": 10,
                  "spaceName": "ARÇELİK",
                  "giftCardUserId": "905001112233",
                  "currency": "TRY",
                  "totalAvailableBalance": 750.00,
                  "maximumUsableAmount": 600.00,
                  "balances": [{
                    "type": "CORPORATE",
                    "availableBalance": 750.00,
                    "blockedBalance": 0,
                    "giftCards": [{
                      "id": 42,
                      "initialAmount": 1000.00,
                      "availableAmount": 750.00,
                      "blockedAmount": 0,
                      "expiresOn": "2027-09-15",
                      "status": "ACTIVE"
                    }]
                  }]
                }
                """;

        GiftCardBalanceResponse response = gson().fromJson(json, GiftCardBalanceResponse.class);

        assertEquals(GiftCardType.CORPORATE, response.getBalances().get(0).getType());
        assertEquals(LocalDate.of(2027, 9, 15), response.getBalances().get(0).getGiftCards().get(0).getExpiresOn());
        assertEquals(GiftCardBalanceBucketStatus.ACTIVE,
                response.getBalances().get(0).getGiftCards().get(0).getStatus());
    }

    @Test
    void shouldDeserializeGiftCardRefundFields() throws Exception {
        String json = """
                {
                  "id": 99,
                  "refundPrice": 600.00,
                  "refundGiftCardPrice": 200.00,
                  "giftCardRefundStatus": "COMPLETED"
                }
                """;

        PaymentTransactionRefundResponse response = gson().fromJson(json, PaymentTransactionRefundResponse.class);

        assertEquals(new BigDecimal("200.00"), response.getRefundGiftCardPrice());
        assertEquals(GiftCardRefundStatus.COMPLETED, response.getGiftCardRefundStatus());
    }

    private Gson gson() throws Exception {
        Field field = HttpClient.class.getDeclaredField("gson");
        field.setAccessible(true);
        return (Gson) field.get(null);
    }
}
