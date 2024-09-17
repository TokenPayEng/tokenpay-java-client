package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.model.PaymentGroup;
import tr.com.tokenpay.model.PaymentPhase;
import tr.com.tokenpay.model.PaymentType;
import tr.com.tokenpay.request.common.Request;
import tr.com.tokenpay.request.dto.Card;
import tr.com.tokenpay.request.dto.PaymentItem;

import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
public class CreateCreditPaymentRequest implements Request {

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
    protected Integer paymentOrder;
    protected PaymentType paymentType;

    protected Long buyerId;
    protected Card card;
    protected String posAlias;
    protected List<PaymentItem> items;

    private String productType;
    private String merchantBranchName;
    private String callbackUrl;
    private Long creditorId;
}