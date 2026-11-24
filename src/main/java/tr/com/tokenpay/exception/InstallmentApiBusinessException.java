package tr.com.tokenpay.exception;

public class InstallmentApiBusinessException extends TokenPayException {

    public static final String PRODUCT_CATEGORY_NOT_FOUND = "5180";

    public InstallmentApiBusinessException(String errorCode, String errorDescription, String errorGroup) {
        super(errorCode, errorDescription, errorGroup);
    }
}
