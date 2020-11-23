package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.RefundDestinationType;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class RefundPaymentRequest implements Request {

    private Long paymentId;
    private String conversationId;

    @Builder.Default
    private RefundDestinationType refundDestinationType = RefundDestinationType.CARD;
}