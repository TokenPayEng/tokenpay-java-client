package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import tr.com.tokenpay.model.*;
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
    private BigDecimal pointPrice = BigDecimal.ZERO;

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

    private String merchantBranchName;
    private PosBlockageResolveType blockageResolveType;
    private Long creditorId;
    private WalletIntegratorType walletIntegratorType;
}