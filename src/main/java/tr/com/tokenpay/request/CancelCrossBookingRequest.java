package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class CancelCrossBookingRequest implements Request {

    private Long crossBookingId;
}
