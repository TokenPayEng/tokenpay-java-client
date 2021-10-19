package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.model.TransactionStatus;
import tr.com.tokenpay.response.dto.Payout;

import java.math.BigDecimal;

@Data
public class PaymentTransactionResponse {

    private Long id;
    private String name;
    private String externalId;
    private TransactionStatus transactionStatus;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private BigDecimal merchantPayoutAmount;
    private Long subMerchantId;
    private BigDecimal subMerchantPrice;
    private BigDecimal subMerchantPayoutRate;
    private BigDecimal subMerchantPayoutAmount;
    private Payout payout;
}