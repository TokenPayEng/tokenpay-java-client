package tr.com.tokenpay.request;

import lombok.Data;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class InitThreeDSPaymentRequest extends CreatePaymentRequest {

    private String callbackUrl;
}
