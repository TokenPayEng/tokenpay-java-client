package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.SubMerchantType;
import tr.com.tokenpay.request.common.Request;

import java.util.Set;

@Data
@Builder
public class SearchSubMerchantsRequest implements Request {

    private String name;
    private Set<Long> subMerchantIds;
    private String subMerchantExternalId;
    private SubMerchantType subMerchantType;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Integer size = 10;
}
