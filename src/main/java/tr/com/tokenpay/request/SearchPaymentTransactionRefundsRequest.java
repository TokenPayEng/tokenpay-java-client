package tr.com.tokenpay.request;

import lombok.Data;
import lombok.Builder;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class SearchPaymentTransactionRefundsRequest implements Request {

    private Long paymentId;
    private String conversationId;
    private Long paymentTransactionId;
}
