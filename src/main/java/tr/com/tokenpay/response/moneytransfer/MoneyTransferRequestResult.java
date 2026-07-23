package tr.com.tokenpay.response.moneytransfer;

import lombok.Data;

@Data
public class MoneyTransferRequestResult
{
    private Long requestId;

    private String code;

    private String token;

    private AccountResult accountResult;
}
