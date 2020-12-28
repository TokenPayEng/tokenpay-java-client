package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
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
public class InitCheckoutPaymentRequest implements Request {

    protected BigDecimal price;
    protected BigDecimal paidPrice;

    @Builder.Default
    protected BigDecimal walletPrice = BigDecimal.ZERO;

    protected Currency currency;
    protected PaymentGroup paymentGroup;
    protected String conversationId;
    protected Integer installment;
    protected String callbackUrl;

    @Builder.Default
    protected PaymentPhase paymentPhase = PaymentPhase.AUTH;

    protected String cardUserKey;

    protected Long buyerId;
    protected List<PaymentItem> items;
}