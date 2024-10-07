package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ReorganizeItemRequest {
    private Long paymentTransactionId;
    private BigDecimal price;
    private Long subMerchantId;
    private String externalId;
}
