package tr.com.tokenpay.response.wallet;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InitResponse
{
    private String id;
    private String source;
    private Long timestamp;
    private String resultCode;
    private String resultMessage;
    private ArrayList<ResponseError> errors;
    private ResponseData response;
}
