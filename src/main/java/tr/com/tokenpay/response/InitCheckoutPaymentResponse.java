package tr.com.tokenpay.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import tr.com.tokenpay.request.common.Request;

@Data
@SuperBuilder
public class InitCheckoutPaymentResponse implements Request {

    protected String token;
    protected String pageUrl;
}