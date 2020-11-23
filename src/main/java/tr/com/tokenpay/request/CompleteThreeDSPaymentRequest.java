package tr.com.tokenpay.request;

import lombok.Data;
import lombok.Builder;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class CompleteThreeDSPaymentRequest implements Request {

    private Long paymentId;
}
