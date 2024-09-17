package tr.com.tokenpay.response;

import lombok.Data;

@Data
public class CreditPaymentResponse {
    private String errorMessage;
    private String redirectURL;
    private int resultCode;
    private String resultExplanation;
    private String htmlContent;
    private Long paymentId;
}
