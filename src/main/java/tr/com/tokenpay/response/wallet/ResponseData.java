package tr.com.tokenpay.response.wallet;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseData {
    private String orderId;
    private String status;
    private ResponseDataRedirectUrl redirectUrl;

}
