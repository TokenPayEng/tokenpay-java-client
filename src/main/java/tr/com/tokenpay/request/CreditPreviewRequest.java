package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class CreditPreviewRequest implements Request {
    private String amount;
    private String productType;
    private Long creditorId;
}
