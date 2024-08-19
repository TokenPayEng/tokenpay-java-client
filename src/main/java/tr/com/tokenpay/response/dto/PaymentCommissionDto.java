package tr.com.tokenpay.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCommissionDto {
    private BigDecimal pfCommissionRateAmount;
    private BigDecimal merchantCommissionRate;
    private BigDecimal merchantCommissionRateAmount;
}
