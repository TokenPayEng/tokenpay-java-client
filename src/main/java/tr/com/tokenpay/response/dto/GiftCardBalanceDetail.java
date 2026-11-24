package tr.com.tokenpay.response.dto;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.GiftCardBalanceBucketStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class GiftCardBalanceDetail {

    private Long id;
    private BigDecimal initialAmount;
    private BigDecimal availableAmount;
    private BigDecimal blockedAmount;
    private LocalDate expiresOn;
    private GiftCardBalanceBucketStatus status;
    private Long paymentId;
    private Long paymentTransactionId;
}
