package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

import java.util.List;

@Data
@Builder
public class PaymentTransactionReorganizeRequest implements Request {

    private Long paymentId;
    private List<ReorganizeItemRequest> items;

}
