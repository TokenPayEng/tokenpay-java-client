package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.response.dto.PayoutCompletedTransaction;

import java.util.List;

@Data
public class PayoutCompletedTransactionListResponse {

    private Long size;
    private List<PayoutCompletedTransaction> items;
}
