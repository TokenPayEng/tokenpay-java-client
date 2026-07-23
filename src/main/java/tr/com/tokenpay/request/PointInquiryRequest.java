package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.request.common.Request;

import java.math.BigDecimal;

@Data
@Builder
public class PointInquiryRequest implements Request
{
    private String cardNumber;
    private String expireYear;
    private String expireMonth;
    @NonNull
    private Currency currency;
    private BigDecimal paidPrice;
}
