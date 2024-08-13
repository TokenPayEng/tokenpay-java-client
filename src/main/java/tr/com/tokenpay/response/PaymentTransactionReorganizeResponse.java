package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.request.ReorganizeItemRequest;

import java.util.List;

@Data
public class PaymentTransactionReorganizeResponse {
    private Long paymentId;
    private List<ReorganizeItemRequest> items;
}
