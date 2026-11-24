package tr.com.tokenpay.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.com.tokenpay.model.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransactionDetail {

    private Long id;
    private LocalDateTime createdDate;
    private String externalId;
    private TransactionStatus transactionStatus;
    private LocalDateTime transactionStatusDate;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal pointPrice;
    private BigDecimal walletPrice;
    private BigDecimal merchantPayoutAmount;
    private Long subMerchantId;
    private String subMerchantName;
    private BigDecimal subMerchantPrice;
    private BigDecimal subMerchantPayoutRate;
    private BigDecimal subMerchantPayoutAmount;
    private Payout payout;
    private PaymentTransactionCard paymentTransactionCard;
    private List<PaymentTransactionRefund> paymentTransactionRefunds;
}
