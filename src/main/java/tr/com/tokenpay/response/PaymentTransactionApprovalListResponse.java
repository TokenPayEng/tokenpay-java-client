package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.response.dto.PaymentTransactionApproval;

import java.util.List;

@Data
public class PaymentTransactionApprovalListResponse {

    private Long size;
    private List<PaymentTransactionApproval> items;
}
