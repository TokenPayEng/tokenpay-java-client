package tr.com.tokenpay.response.dto;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentTransaction {

    private Long id;
    private String externalId;
    private String name;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal pointPrice;
    private BigDecimal walletPrice;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal merchantPayoutAmount;
    private Long subMerchantId;
    private BigDecimal subMerchantPrice;
    private BigDecimal subMerchantPayoutRate;
    private BigDecimal subMerchantPayoutAmount;
    private BigDecimal pfCommissionRateAmount;
    private TransactionStatus transactionStatus;
    private LocalDateTime blockageResolvedDate;
    private Payout payout;
}
