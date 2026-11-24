package tr.com.tokenpay.request.moneytransfer;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import tr.com.tokenpay.request.common.Request;

@Data
@SuperBuilder
public class MoneyTransferUpdateRequest implements Request
{
    private Long requestId;
    private String code;
}
