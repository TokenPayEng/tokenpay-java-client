package tr.com.tokenpay.response.dto;

import java.util.Arrays;

public enum PaymentMultiCardStatus {
    SUCCESS(0),
    FIRST_PRE_AUTH(1),
    SECOND_PRE_AUTH(2),
    FIRST_POST_AUTH_INVOKE_FAILED(3),
    SECOND_POST_AUTH_INVOKE_FAILED(4),
    FIRST_PRE_AUTH_CANCEL_BY_TIMEOUT(5),
    FIRST_PRE_AUTH_CANCEL_BY_TIMEOUT_FAILED(6);
    private final int code;
    PaymentMultiCardStatus(int code) {
        this.code = code;
    }
    public static PaymentMultiCardStatus of(Integer value) {
        return Arrays.stream(PaymentMultiCardStatus.values())
                .filter(c -> c.code == value)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Value:" + value + " not supported"));
    }
}
