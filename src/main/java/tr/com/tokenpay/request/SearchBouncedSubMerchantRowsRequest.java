package tr.com.tokenpay.request;

import lombok.Data;
import lombok.Builder;
import tr.com.tokenpay.request.common.Request;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchBouncedSubMerchantRowsRequest implements Request {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
