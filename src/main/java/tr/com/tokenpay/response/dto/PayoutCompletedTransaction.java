package tr.com.tokenpay.response.dto;

import lombok.Data;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.model.MerchantType;

import java.math.BigDecimal;

@Data
public class PayoutCompletedTransaction {

    private Long transactionId;
    private String transactionType;
    private BigDecimal payoutAmount;
    private Currency currency;
    private Long merchantId;
    private MerchantType merchantType;
}
