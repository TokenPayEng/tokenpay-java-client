package tr.com.tokenpay.request.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Maturity {
    private Integer installmentNumber;
    private BigDecimal itemMaturityRate;
}
