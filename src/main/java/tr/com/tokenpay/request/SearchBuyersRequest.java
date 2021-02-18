package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.Status;
import tr.com.tokenpay.model.SubMerchantType;
import tr.com.tokenpay.request.common.Request;

import java.util.Set;

@Data
@Builder
public class SearchBuyersRequest implements Request {

    private Status status;
    private String email;
    private String identityNumber;
    private String name;
    private String surname;
    private String gsmNumber;
    private String buyerExternalId;

    @Builder.Default
    private Integer page;

    @Builder.Default
    private Integer size;
}
