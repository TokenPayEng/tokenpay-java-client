package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import lombok.Builder;
import tr.com.tokenpay.model.CardAssociation;
import tr.com.tokenpay.model.CardType;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class SearchStoredCardsRequest implements Request {

    private String cardAlias;
    private String cardBrand;
    private CardType cardType;
    private String cardUserKey;
    private String cardToken;
    private String cardBankName;
    private CardAssociation cardAssociation;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}
