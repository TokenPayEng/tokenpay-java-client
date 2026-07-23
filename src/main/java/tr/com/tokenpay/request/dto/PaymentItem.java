package tr.com.tokenpay.request.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentItem {

    private String name;
    private BigDecimal price;
    private String externalId;
    private Long subMerchantId;
    private BigDecimal subMerchantPrice;
    private String productItemCode;
}
