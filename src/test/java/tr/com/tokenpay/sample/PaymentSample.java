package tr.com.tokenpay.sample;

import org.junit.jupiter.api.Test;
import tr.com.tokenpay.TokenPay;
import tr.com.tokenpay.model.*;
import tr.com.tokenpay.request.*;
import tr.com.tokenpay.request.dto.Card;
import tr.com.tokenpay.request.dto.PaymentItem;
import tr.com.tokenpay.response.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentSample {

    private final TokenPay tokenPay = new TokenPay("api-key", "secret-key", "https://api-gateway.tokenpay.com.tr");

    @Test
    void create_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .build());

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = tokenPay.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
    }

    @Test
    void create_marketplace_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .subMerchantId(1L)
                .subMerchantPrice(BigDecimal.valueOf(27))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .subMerchantId(2L)
                .subMerchantPrice(BigDecimal.valueOf(42))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .subMerchantId(3L)
                .subMerchantPrice(BigDecimal.valueOf(18))
                .build());

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.PRODUCT)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = tokenPay.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
    }

    @Test
    void create_payment_and_store_card() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .subMerchantId(1L)
                .subMerchantPrice(BigDecimal.valueOf(27))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .subMerchantId(2L)
                .subMerchantPrice(BigDecimal.valueOf(42))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .subMerchantId(3L)
                .subMerchantPrice(BigDecimal.valueOf(18))
                .build());

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.PRODUCT)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .storeCardAfterSuccessPayment(true)
                        .cardAlias("My YKB Card")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = tokenPay.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNotNull(response.getCardUserKey());
        assertNotNull(response.getCardToken());
    }

    @Test
    void create_gateway_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .build());

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .posAlias("62-YKB-1")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = tokenPay.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
    }

    @Test
    void init_3DS_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .subMerchantId(1L)
                .subMerchantPrice(BigDecimal.valueOf(27))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .subMerchantId(2L)
                .subMerchantPrice(BigDecimal.valueOf(42))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .subMerchantId(3L)
                .subMerchantPrice(BigDecimal.valueOf(18))
                .build());

        InitThreeDSPaymentRequest request = InitThreeDSPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .callbackUrl("https://www.your-website.com/tokenpay-3DSecure-callback")
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.PRODUCT)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        InitThreeDSPaymentResponse response = tokenPay.payment().init3DSPayment(request);
        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getDecodedHtmlContent());
    }

    @Test
    void init_3DS_payment_gateway_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .subMerchantId(1L)
                .subMerchantPrice(BigDecimal.valueOf(27))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .subMerchantId(2L)
                .subMerchantPrice(BigDecimal.valueOf(42))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .subMerchantId(3L)
                .subMerchantPrice(BigDecimal.valueOf(18))
                .build());

        InitThreeDSPaymentRequest request = InitThreeDSPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .callbackUrl("https://www.your-website.com/tokenpay-3DSecure-callback")
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .posAlias("62-YKB-1")
                .paymentGroup(PaymentGroup.PRODUCT)
                .paymentPhase(PaymentPhase.AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        InitThreeDSPaymentResponse response = tokenPay.payment().init3DSPayment(request);
        assertNotNull(response);
        assertNotNull(response.getHtmlContent());
        assertNotNull(response.getDecodedHtmlContent());
    }

    @Test
    void complete_3DS_payment() {
        CompleteThreeDSPaymentRequest request = CompleteThreeDSPaymentRequest.builder()
                .paymentId(1L)
                .build();

        PaymentResponse response = tokenPay.payment().complete3DSPayment(request);
        assertNotNull(response);
    }

    @Test
    void init_checkout_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .build());

        InitCheckoutPaymentRequest request = InitCheckoutPaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.AUTH)
                .cardUserKey("eee24372-1735-4bc1-a534-023f1e02a03e")
                .callbackUrl("https://www.your-website.com/tokenpay-checkout-callback")
                .items(items)
                .buyerId(1L)
                .build();

        InitCheckoutPaymentResponse response = tokenPay.payment().initCheckoutPayment(request);
        assertNotNull(response);
    }

    @Test
    void retrieve_checkout_payment() {
        String token = "fe4b0c2d-3c48-4553-9429-695d204bd7c1";

        PaymentResponse response = tokenPay.payment().retrieveCheckoutPayment(token);
        assertNotNull(response);
    }

    @Test
    void approve_payment_transactions() {
        ApprovePaymentTransactionsRequest request = ApprovePaymentTransactionsRequest.builder()
                .isTransactional(true)
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTransactionApprovalListResponse response = tokenPay.payment().approvePaymentTransactions(request);
        assertNotNull(response);
        assertEquals(2, response.getSize());
    }

    @Test
    void disapprove_payment_transactions() {
        DisapprovePaymentTransactionsRequest request = DisapprovePaymentTransactionsRequest.builder()
                .isTransactional(true)
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTransactionApprovalListResponse response = tokenPay.payment().disapprovePaymentTransactions(request);
        assertNotNull(response);
        assertEquals(2, response.getSize());
    }

    @Test
    void retrieve_payment() {
        Long paymentId = 1L;

        PaymentDetailResponse response = tokenPay.payment().retrievePayment(paymentId);
        assertNotNull(response);
        assertEquals(paymentId, response.getId());
    }

    @Test
    void search_payments() {
        SearchPaymentsRequest request = SearchPaymentsRequest.builder()
                .currency(Currency.TRY)
                .paymentStatus(PaymentStatus.SUCCESS)
                .build();

        PaymentDetailListResponse response = tokenPay.payment().searchPayments(request);
        assertNotNull(response);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void refund_payment() {
        RefundPaymentRequest request = RefundPaymentRequest.builder()
                .paymentId(1L)
                .refundDestinationType(RefundDestinationType.CARD)
                .build();

        PaymentRefundResponse response = tokenPay.payment().refundPayment(request);
        assertNotNull(response);
        assertEquals(request.getPaymentId(), response.getPaymentId());
        assertEquals(RefundStatus.SUCCESS, response.getStatus());
    }

    @Test
    void retrieve_payment_refund() {
        Long paymentRefundId = 1L;

        PaymentRefundResponse response = tokenPay.payment().retrievePaymentRefund(paymentRefundId);
        assertNotNull(response);
        assertEquals(paymentRefundId, response.getId());
    }

    @Test
    void refund_payment_transaction() {
        RefundPaymentTransactionRequest request = RefundPaymentTransactionRequest.builder()
                .paymentTransactionId(1L)
                .refundPrice(BigDecimal.valueOf(20))
                .refundDestinationType(RefundDestinationType.CARD)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .build();

        PaymentTransactionRefundResponse response = tokenPay.payment().refundPaymentTransaction(request);
        assertNotNull(response);
        assertEquals(request.getPaymentTransactionId(), response.getPaymentTransactionId());
        assertEquals(RefundStatus.SUCCESS, response.getStatus());
    }

    @Test
    void retrieve_payment_transaction_refund() {
        Long paymentTransactionRefundId = 1L;

        PaymentTransactionRefundResponse response = tokenPay.payment().retrievePaymentTransactionRefund(paymentTransactionRefundId);
        assertNotNull(response);
        assertEquals(paymentTransactionRefundId, response.getId());
        assertEquals(RefundStatus.SUCCESS, response.getStatus());
    }

    @Test
    void search_payment_transaction_refunds() {
        SearchPaymentTransactionRefundsRequest request = SearchPaymentTransactionRefundsRequest.builder()
                .paymentId(1L)
                .build();

        PaymentTransactionRefundListResponse response = tokenPay.payment().searchPaymentTransactionRefunds(request);
        assertNotNull(response);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void delete_stored_card() {
        DeleteStoredCardRequest request = DeleteStoredCardRequest.builder()
                .cardUserKey("fac377f2-ab15-4696-88d2-5e71b27ec378")
                .cardToken("11a078c4-3c32-4796-90b1-51ee5517a212")
                .build();

        tokenPay.payment().deleteStoredCard(request);
    }

    @Test
    void search_stored_cards() {
        SearchStoredCardsRequest request = SearchStoredCardsRequest.builder()
                .cardAlias("My YKB Card")
                .cardBankName("YAPI VE KREDİ BANKASI A.Ş.")
                .cardBrand("World")
                .cardAssociation(CardAssociation.MASTER_CARD)
                .cardToken("d9b19d1a-243c-43dc-a498-add08162df72")
                .cardUserKey("c115ecdf-0afc-4d83-8a1b-719c2af19cbd")
                .cardType(CardType.CREDIT_CARD)
                .build();

        StoredCardListResponse response = tokenPay.payment().searchStoredCards(request);
        assertNotNull(response);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void create_pre_auth_payment() {
        List<PaymentItem> items = new ArrayList<>();

        items.add(PaymentItem.builder()
                .name("item 1")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(30))
                .build());

        items.add(PaymentItem.builder()
                .name("item 2")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(50))
                .build());

        items.add(PaymentItem.builder()
                .name("item 3")
                .externalId(UUID.randomUUID().toString())
                .price(BigDecimal.valueOf(20))
                .build());

        CreatePaymentRequest request = CreatePaymentRequest.builder()
                .price(BigDecimal.valueOf(100))
                .paidPrice(BigDecimal.valueOf(100))
                .walletPrice(BigDecimal.ZERO)
                .installment(1)
                .currency(Currency.TRY)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .paymentGroup(PaymentGroup.LISTING_OR_SUBSCRIPTION)
                .paymentPhase(PaymentPhase.PRE_AUTH)
                .card(Card.builder()
                        .cardHolderName("Haluk Demir")
                        .cardNumber("5258640000000001")
                        .expireYear("2044")
                        .expireMonth("07")
                        .cvc("000")
                        .build())
                .items(items)
                .build();

        PaymentResponse response = tokenPay.payment().createPayment(request);
        assertNotNull(response.getId());
        assertEquals(request.getPrice(), response.getPrice());
        assertEquals(request.getPaidPrice(), response.getPaidPrice());
        assertEquals(request.getWalletPrice(), response.getWalletPrice());
        assertEquals(request.getCurrency(), response.getCurrency());
        assertEquals(request.getInstallment(), response.getInstallment());
        assertEquals(request.getPaymentGroup(), response.getPaymentGroup());
        assertEquals(request.getPaymentPhase(), response.getPaymentPhase());
        assertEquals(false, response.getIsThreeDS());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRate());
        assertEquals(BigDecimal.ZERO, response.getMerchantCommissionRateAmount());
        assertEquals(false, response.getPaidWithStoredCard());
        assertEquals("525864", response.getBinNumber());
        assertEquals("0001", response.getLastFourDigits());
        assertEquals(CardType.CREDIT_CARD, response.getCardType());
        assertEquals(CardAssociation.MASTER_CARD, response.getCardAssociation());
        assertEquals("World", response.getCardBrand());
        assertEquals(3, response.getPaymentTransactions().size());
        assertNull(response.getCardUserKey());
        assertNull(response.getCardToken());
    }

    @Test
    void post_auth_payment() {
        long paymentId = 1L;
        PostAuthPaymentRequest request = PostAuthPaymentRequest.builder()
                .paidPrice(BigDecimal.valueOf(100))
                .build();

        PaymentResponse response = tokenPay.payment().postAuthPayment(paymentId, request);
        assertEquals(paymentId, response.getId());
        assertEquals(PaymentPhase.POST_AUTH, response.getPaymentPhase());
    }

    @Test
    void update_payment_transaction() {
        long paymentTransactionId = 100L;
        UpdatePaymentTransactionRequest request = UpdatePaymentTransactionRequest.builder()
                .subMerchantId(2L)
                .subMerchantPrice(BigDecimal.valueOf(10))
                .build();

        PaymentTransactionResponse response = tokenPay.payment().updatePaymentTransaction(paymentTransactionId, request);
        assertEquals(response.getId(), paymentTransactionId);
    }
}
