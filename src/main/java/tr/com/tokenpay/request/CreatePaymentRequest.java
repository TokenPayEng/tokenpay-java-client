package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import lombok.Builder;
import lombok.experimental.SuperBuilder;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.model.PaymentGroup;
import tr.com.tokenpay.model.PaymentPhase;
import tr.com.tokenpay.request.common.Request;
import tr.com.tokenpay.request.dto.Card;
import tr.com.tokenpay.request.dto.PaymentItem;

import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
public class CreatePaymentRequest implements Request {

    protected BigDecimal price;
    protected BigDecimal paidPrice;

    @Builder.Default
    protected BigDecimal walletPrice = BigDecimal.ZERO;

    protected Integer installment;
    protected Currency currency;
    protected PaymentGroup paymentGroup;
    protected String conversationId;

    @Builder.Default
    protected PaymentPhase paymentPhase = PaymentPhase.AUTH;

    protected Long buyerId;
    protected Card card;
    protected List<PaymentItem> items;
}