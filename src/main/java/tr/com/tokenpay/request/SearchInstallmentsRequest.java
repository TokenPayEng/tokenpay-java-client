package tr.com.tokenpay.request;

import lombok.Data;
import lombok.Builder;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.request.common.Request;

import java.math.BigDecimal;

@Data
@Builder
public class SearchInstallmentsRequest implements Request {

    private String binNumber;
    private BigDecimal price;
    private Currency currency;
}
