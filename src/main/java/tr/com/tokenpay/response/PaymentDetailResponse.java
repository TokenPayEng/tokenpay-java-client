package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.model.ConnectorType;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.model.PaymentStatus;
import tr.com.tokenpay.model.PaymentType;
import tr.com.tokenpay.response.dto.PaymentCard;
import tr.com.tokenpay.response.dto.PaymentCommissionDto;
import tr.com.tokenpay.response.dto.PaymentRefund;
import tr.com.tokenpay.response.dto.PaymentTransactionDetail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaymentDetailResponse {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String orderId;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private PaymentType paymentType;
    private ConnectorType connectorType;
    private Currency currency;
    private PaymentStatus paymentStatus;
    private String conversationId;
    private PaymentCard paymentCard;
    private List<PaymentRefund> paymentRefunds;
    private List<PaymentTransactionDetail> paymentTransactions;
    private PaymentCommissionDto paymentCommission;
}
