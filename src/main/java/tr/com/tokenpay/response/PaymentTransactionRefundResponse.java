package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.model.GiftCardRefundStatus;
import tr.com.tokenpay.model.RefundDestinationType;
import tr.com.tokenpay.model.RefundStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentTransactionRefundResponse {

    private Long id;
    private String conversationId;
    private LocalDateTime createdDate;
    private RefundStatus status;
    private Boolean isAfterSettlement;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private BigDecimal refundGiftCardPrice;
    private GiftCardRefundStatus giftCardRefundStatus;
    private Currency currency;
    private Long paymentTransactionId;
    private Long paymentId;
    private RefundDestinationType refundDestinationType;
}
