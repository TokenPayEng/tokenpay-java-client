package tr.com.tokenpay.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tr.com.tokenpay.response.common.ListResponse;

@EqualsAndHashCode(callSuper = true)
@Data
public class SubMerchantListResponse extends ListResponse<SubMerchantResponse> {

}
