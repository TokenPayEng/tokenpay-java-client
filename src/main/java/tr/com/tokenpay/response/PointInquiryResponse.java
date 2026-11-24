package tr.com.tokenpay.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PointInquiryResponse
{
    BigDecimal point;
    BigDecimal pointPrice;
    BigDecimal loyaltyPoint;
    BigDecimal loyaltyPointPrice;
    BigDecimal totalPoint;
    BigDecimal totalPointPrice;
    String errorMessage;
}
