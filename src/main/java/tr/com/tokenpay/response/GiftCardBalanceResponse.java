package tr.com.tokenpay.response;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.response.dto.GiftCardTypeBalance;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class GiftCardBalanceResponse {

    private Long spaceId;
    private String spaceName;
    private String giftCardUserId;
    private Currency currency;
    private BigDecimal totalAvailableBalance;
    private BigDecimal maximumUsableAmount;
    private List<GiftCardTypeBalance> balances;
}
