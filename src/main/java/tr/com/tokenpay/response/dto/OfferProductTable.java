package tr.com.tokenpay.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferProductTable {
    private String insuranceAmount;
    private String productCode;
    private String effectiveInterestRateMonthly;
    private String installmentAmount;
    private String creditInterest;
    private String term;
    private String totalPaymentAmount;
    private String productName;
    private String effectiveInterestRate;
}
