package tr.com.tokenpay.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.request.common.BaseRequest;

import java.math.BigDecimal;

@Data
@SuperBuilder
public class SearchInstallmentsRequest extends BaseRequest {

    private String binNumber;
    private BigDecimal price;
    private Currency currency;
}
