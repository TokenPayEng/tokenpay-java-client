package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class SearchPaymentTransactionRefundsRequest implements Request {

    private Long paymentId;
    private String conversationId;
    private Long paymentTransactionId;
}
