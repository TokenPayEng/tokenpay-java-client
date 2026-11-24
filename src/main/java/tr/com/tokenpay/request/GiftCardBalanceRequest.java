package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.request.common.Request;

import java.math.BigDecimal;

@Data
@Builder
public class GiftCardBalanceRequest implements Request {

    private Long merchantId;
    private String merchantBranchName;
    private Long subMerchantId;
    private String giftCardUserId;
    private Currency currency;
    private BigDecimal eligibleAmount;
}
