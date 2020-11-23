package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class DeleteStoredCardRequest implements Request {

    private String cardUserKey;
    private String cardToken;
}
