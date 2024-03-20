package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.response.dto.PaymentMultiCardStatus;

import java.util.List;

@Data
public class PostAuthPaymentResponse {

    private String conversationId;
    private PaymentMultiCardStatus paymentMultiCardStatus;
    private boolean multiPayment;
    private List<Long> paymentIdList;
}
