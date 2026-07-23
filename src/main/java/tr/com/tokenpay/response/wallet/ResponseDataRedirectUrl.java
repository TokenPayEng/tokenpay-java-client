package tr.com.tokenpay.response.wallet;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDataRedirectUrl {
    private String link;
    private String type;
}
