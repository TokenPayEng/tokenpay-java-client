package tr.com.tokenpay.request.dto;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.GiftCardType;

@Data
@Builder
public class GiftCardItem {

    private GiftCardType type;
    private String giftCardUserId;
}
