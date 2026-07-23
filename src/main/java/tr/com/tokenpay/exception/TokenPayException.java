package tr.com.tokenpay.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TokenPayException extends RuntimeException {

    private final String GENERAL_ERROR_CODE = "0";
    private final String GENERAL_ERROR_DESCRIPTION = "An error occurred.";
    private final String GENERAL_ERROR_GROUP = "Unknown";
    private final String errorCode;
    private final String errorDescription;
    private final String errorGroup;

    public TokenPayException(String errorCode, String errorDescription, String errorGroup) {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorGroup = errorGroup;
    }

    public TokenPayException(Throwable cause) {
        super(cause.getMessage(), cause);
        this.errorCode = GENERAL_ERROR_CODE;
        this.errorDescription = GENERAL_ERROR_DESCRIPTION;
        this.errorGroup = GENERAL_ERROR_GROUP;
    }
}
