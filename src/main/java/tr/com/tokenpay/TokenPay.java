package tr.com.tokenpay;

import tr.com.tokenpay.adapter.*;
import tr.com.tokenpay.request.common.RequestOptions;

public class TokenPay {

    private static final String BASE_URL = "https://api-gateway.tokenpay.com.tr";

    private final PaymentAdapter payment;
    private final SettlementReportingAdapter settlementReportingAdapter;
    private final InstallmentAdapter installmentAdapter;
    private final OnboardingAdapter onboardingAdapter;
    private final LinkAdapter linkAdapter;

    public TokenPay(String apiKey, String secretKey) {
        this(apiKey, secretKey, BASE_URL);
    }

    public TokenPay(String apiKey, String secretKey, String baseUrl) {
        RequestOptions requestOptions = RequestOptions.builder()
                .apiKey(apiKey)
                .secretKey(secretKey)
                .baseUrl(baseUrl)
                .build();

        this.payment = new PaymentAdapter(requestOptions);
        this.settlementReportingAdapter = new SettlementReportingAdapter(requestOptions);
        this.installmentAdapter = new InstallmentAdapter(requestOptions);
        this.onboardingAdapter = new OnboardingAdapter(requestOptions);
        this.linkAdapter = new LinkAdapter(requestOptions);
    }

    public PaymentAdapter payment() {
        return payment;
    }

    public SettlementReportingAdapter settlementReporting() {
        return settlementReportingAdapter;
    }

    public InstallmentAdapter installment() {
        return installmentAdapter;
    }

    public OnboardingAdapter onboarding() {
        return onboardingAdapter;
    }

    public LinkAdapter link() {
        return linkAdapter;
    }
}
