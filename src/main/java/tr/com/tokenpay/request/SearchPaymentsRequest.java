package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import lombok.Builder;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.model.PaymentStatus;
import tr.com.tokenpay.request.common.Request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class SearchPaymentsRequest implements Request {

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;

    private Set<Long> paymentIds;
    private Set<Long> paymentTransactionIds;
    private Set<Long> subMerchantIds;
    private Set<String> itemExternalIds;
    private PaymentStatus paymentStatus;

    private Currency currency;
    private String binNumber;
    private String lastFourDigits;

    private BigDecimal minPrice;
    private BigDecimal minPaidPrice;
    private BigDecimal maxPrice;
    private BigDecimal maxPaidPrice;

    private Integer installment;
    private String conversationId;
    private Boolean isThreeDS;
    private LocalDateTime minCreatedDate;
    private LocalDateTime maxCreatedDate;
}
