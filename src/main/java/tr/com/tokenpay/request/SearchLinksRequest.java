package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.Status;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class SearchLinksRequest implements Request {

    private String name;
    private String token;
    private Status status;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}
