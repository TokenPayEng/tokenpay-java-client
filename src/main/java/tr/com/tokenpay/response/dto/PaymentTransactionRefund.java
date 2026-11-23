package tr.com.tokenpay.response.dto;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.PaymentType;
import tr.com.tokenpay.model.GiftCardRefundStatus;
import tr.com.tokenpay.model.RefundDestinationType;
import tr.com.tokenpay.model.RefundStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentTransactionRefund {

    private Long id;
    private LocalDateTime createdDate;
    private RefundStatus refundStatus;
    private RefundDestinationType refundDestinationType;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private BigDecimal refundGiftCardPrice;
    private GiftCardRefundStatus giftCardRefundStatus;
    private PaymentType paymentType;
    private String conversationId;
    private Boolean isAfterSettlement;
    private Error error;
}
