package tr.com.tokenpay.net;

import org.junit.jupiter.api.Test;
import tr.com.tokenpay.exception.InstallmentApiBusinessException;
import tr.com.tokenpay.exception.TokenPayException;
import tr.com.tokenpay.response.common.ErrorResponse;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HttpClientTest {

    @Test
    void shouldCreateInstallmentExceptionForInstallmentBusinessError() throws Exception {
        ErrorResponse error = ErrorResponse.builder()
                .errorCode(InstallmentApiBusinessException.PRODUCT_CATEGORY_NOT_FOUND)
                .errorDescription("Product category not found")
                .errorGroup("Unknown")
                .build();

        TokenPayException exception = createException(error);

        assertTrue(exception instanceof InstallmentApiBusinessException);
        assertEquals(error.getErrorCode(), exception.getErrorCode());
        assertEquals(error.getErrorDescription(), exception.getErrorDescription());
        assertEquals(error.getErrorGroup(), exception.getErrorGroup());
    }

    @Test
    void shouldCreateTokenPayExceptionForOtherErrors() throws Exception {
        ErrorResponse error = ErrorResponse.builder()
                .errorCode("OTHER_ERROR")
                .errorDescription("Other error")
                .errorGroup("Other")
                .build();

        TokenPayException exception = createException(error);

        assertEquals(TokenPayException.class, exception.getClass());
        assertEquals(error.getErrorCode(), exception.getErrorCode());
        assertEquals(error.getErrorDescription(), exception.getErrorDescription());
        assertEquals(error.getErrorGroup(), exception.getErrorGroup());
    }

    private TokenPayException createException(ErrorResponse error) throws Exception {
        Method method = HttpClient.class.getDeclaredMethod("createException", ErrorResponse.class);
        method.setAccessible(true);
        return (TokenPayException) method.invoke(null, error);
    }
}
