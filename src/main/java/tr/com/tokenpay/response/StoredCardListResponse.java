package tr.com.tokenpay.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.com.tokenpay.response.common.ListResponse;
import tr.com.tokenpay.response.dto.StoredCard;

@EqualsAndHashCode(callSuper = true)
@Data
public class StoredCardListResponse extends ListResponse<StoredCard> {

}
