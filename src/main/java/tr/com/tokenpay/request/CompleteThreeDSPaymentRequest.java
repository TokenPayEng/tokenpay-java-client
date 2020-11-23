package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class CompleteThreeDSPaymentRequest implements Request {

    private Long paymentId;
}
