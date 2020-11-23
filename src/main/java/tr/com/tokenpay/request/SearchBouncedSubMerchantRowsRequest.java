package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchBouncedSubMerchantRowsRequest implements Request {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
