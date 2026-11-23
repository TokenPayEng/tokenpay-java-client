package tr.com.tokenpay.response.dto;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.GiftCardType;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class GiftCardTypeBalance {

    private GiftCardType type;
    private BigDecimal availableBalance;
    private BigDecimal blockedBalance;
    private List<GiftCardBalanceDetail> giftCards;
}
