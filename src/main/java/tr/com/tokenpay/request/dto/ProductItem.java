package tr.com.tokenpay.request.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductItem {
    private String productItemCode;
    private BigDecimal productItemPrice;
    private List<Maturity> maturity;
}
