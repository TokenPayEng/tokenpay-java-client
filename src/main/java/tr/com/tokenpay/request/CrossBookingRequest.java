package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import lombok.Builder;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.request.common.Request;

import java.math.BigDecimal;

@Data
@Builder
public class CrossBookingRequest implements Request {

    private String reason;
    private BigDecimal price;
    private Currency currency;
    private Long subMerchantId;
}
