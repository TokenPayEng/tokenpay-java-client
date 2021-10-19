package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class UpdatePaymentTransactionsRequest implements Request {

    private Long subMerchantId;
    private BigDecimal subMerchantPrice;
}
