package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.response.dto.OfferProductTable;

import java.util.List;

@Data
public class CreditPreviewResponse {
    private List<OfferProductTable> offerProductTable;
    private int resultCode;
    private String resultExplanation;
}
