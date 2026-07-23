package tr.com.tokenpay.response.moneytransfer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AccountResult
{
    private List<Account> accounts;

    @Builder
    @Data
    public static class Account
    {
        private String iban;
        private String bankCode;
        private String bankName;
    }
}
