package tr.com.tokenpay.response.wallet;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseError
{
    private String code;
    private String type;
    private String message;
}
