package tr.com.tokenpay.response.dto;

import lombok.Data;
import tr.com.tokenpay.model.ApprovalStatus;

@Data
public class PaymentTransactionApproval {

    private Long paymentTransactionId;
    private ApprovalStatus approvalStatus;
    private String failedReason;
}
