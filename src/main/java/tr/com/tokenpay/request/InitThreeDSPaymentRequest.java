package tr.com.tokenpay.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class InitThreeDSPaymentRequest extends CreatePaymentRequest {

    private String callbackUrl;
}
