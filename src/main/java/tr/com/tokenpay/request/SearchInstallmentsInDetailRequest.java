package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.Currency;
import tr.com.tokenpay.request.common.Request;
import tr.com.tokenpay.request.dto.ProductItem;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class SearchInstallmentsInDetailRequest implements Request {

    private String binNumber;
    private BigDecimal price;
    private Currency currency;
    private List<Long> subMerchantIds;
    private List<ProductItem> productItems;
    private String branch;
}
