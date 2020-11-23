package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class CreateBuyerRequest implements Request {

    private String email;
    private String name;
    private String surname;
    private String gsmNumber;
    private String identityNumber;
    private String buyerExternalId;
}
