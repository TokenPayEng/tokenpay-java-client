package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.model.*;
import tr.com.tokenpay.response.dto.PaymentTransaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaymentResponse {

    private Long id;
    private LocalDateTime createdDate;
    private BigDecimal price;
    private BigDecimal paidPrice;
    private BigDecimal walletPrice;
    private Currency currency;
    private Long buyerId;
    private Integer installment;
    private String conversationId;
    private PaymentType paymentType;
    private PaymentGroup paymentGroup;
    private PaymentStatus paymentStatus;
    private ConnectorType connectorType;
    private PaymentPhase paymentPhase;
    private Boolean isThreeDS;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
    private BigDecimal pfCommissionRateAmount;
    private String cardUserKey;
    private String cardToken;
    private Boolean paidWithStoredCard;
    private String binNumber;
    private String lastFourDigits;
    private CardType cardType;
    private CardAssociation cardAssociation;
    private String cardBrand;
    private List<PaymentTransaction> paymentTransactions;
}
