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

    private final TokenPay tokenPay = new TokenPay("api-key", "secret-key", "http://localhost:8000");

    @Test
    void create_payment_sample() {
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

        PaymentResponse paymentResponse = tokenPay.payment().createPayment(request);
        assertNotNull(paymentResponse.getId());
        assertEquals(paymentResponse.getPrice(), request.getPrice());
        assertEquals(paymentResponse.getPaidPrice(), request.getPaidPrice());
        assertEquals(paymentResponse.getWalletPrice(), request.getWalletPrice());
        assertEquals(paymentResponse.getCurrency(), request.getCurrency());
        assertEquals(paymentResponse.getInstallment(), request.getInstallment());
        assertEquals(paymentResponse.getPaymentGroup(), request.getPaymentGroup());
        assertEquals(paymentResponse.getPaymentPhase(), request.getPaymentPhase());
        assertEquals(paymentResponse.getIsThreeDS(), false);
        assertEquals(paymentResponse.getMerchantCommissionRate(), BigDecimal.ZERO);
        assertEquals(paymentResponse.getMerchantCommissionRateAmount(), BigDecimal.ZERO);
        assertEquals(paymentResponse.getPaidWithStoredCard(), false);
        assertEquals(paymentResponse.getBinNumber(), "525864");
        assertEquals(paymentResponse.getLastFourDigits(), "0001");
        assertEquals(paymentResponse.getCardType(), CardType.CREDIT_CARD);
        assertEquals(paymentResponse.getCardAssociation(), CardAssociation.MASTER_CARD);
        assertEquals(paymentResponse.getCardBrand(), "World");
        assertEquals(paymentResponse.getPaymentTransactions().size(), 3);
        assertNull(paymentResponse.getCardUserKey());
        assertNull(paymentResponse.getCardToken());
    }

    @Test
    void create_payment_and_store_card_sample() {
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

        PaymentResponse paymentResponse = tokenPay.payment().createPayment(request);
        assertNotNull(paymentResponse.getId());
        assertEquals(paymentResponse.getPrice(), request.getPrice());
        assertEquals(paymentResponse.getPaidPrice(), request.getPaidPrice());
        assertEquals(paymentResponse.getWalletPrice(), request.getWalletPrice());
        assertEquals(paymentResponse.getCurrency(), request.getCurrency());
        assertEquals(paymentResponse.getInstallment(), request.getInstallment());
        assertEquals(paymentResponse.getPaymentGroup(), request.getPaymentGroup());
        assertEquals(paymentResponse.getPaymentPhase(), request.getPaymentPhase());
        assertEquals(paymentResponse.getIsThreeDS(), false);
        assertEquals(paymentResponse.getMerchantCommissionRate(), BigDecimal.ZERO);
        assertEquals(paymentResponse.getMerchantCommissionRateAmount(), BigDecimal.ZERO);
        assertEquals(paymentResponse.getPaidWithStoredCard(), false);
        assertEquals(paymentResponse.getBinNumber(), "525864");
        assertEquals(paymentResponse.getLastFourDigits(), "0001");
        assertEquals(paymentResponse.getCardType(), CardType.CREDIT_CARD);
        assertEquals(paymentResponse.getCardAssociation(), CardAssociation.MASTER_CARD);
        assertEquals(paymentResponse.getCardBrand(), "World");
        assertEquals(paymentResponse.getPaymentTransactions().size(), 3);
        assertNotNull(paymentResponse.getCardUserKey());
        assertNotNull(paymentResponse.getCardToken());
    }

    @Test
    void init_3ds_payment_sample() {
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

        InitThreeDSPaymentResponse initThreeDSPaymentResponse = tokenPay.payment().init3DSPayment(request);
        assertNotNull(initThreeDSPaymentResponse);
        assertNotNull(initThreeDSPaymentResponse.getHtmlContent());
    }

    @Test
    void complete_3ds_payment_sample() {
        CompleteThreeDSPaymentRequest request = CompleteThreeDSPaymentRequest.builder()
                .paymentId(1L)
                .build();

        PaymentResponse paymentResponse = tokenPay.payment().complete3DSPayment(request);
        assertNotNull(paymentResponse);
    }

    @Test
    void approve_payment_transaction_sample() {
        ApprovePaymentTransactionsRequest request = ApprovePaymentTransactionsRequest.builder()
                .isTransactional(true)
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTransactionApprovalListResponse paymentTransactionApprovalListResponse = tokenPay.payment().approvePaymentTransactions(request);
        assertNotNull(paymentTransactionApprovalListResponse);
        assertEquals(paymentTransactionApprovalListResponse.getSize(), 2);
    }

    @Test
    void disapprove_payment_transaction_sample() {
        DisapprovePaymentTransactionsRequest request = DisapprovePaymentTransactionsRequest.builder()
                .isTransactional(true)
                .paymentTransactionIds(new HashSet<Long>() {{
                    add(1L);
                    add(2L);
                }})
                .build();

        PaymentTransactionApprovalListResponse paymentTransactionApprovalListResponse = tokenPay.payment().disapprovePaymentTransactions(request);
        assertNotNull(paymentTransactionApprovalListResponse);
        assertEquals(paymentTransactionApprovalListResponse.getSize(), 2);
    }

    @Test
    void refund_payment_sample() {
        RefundPaymentRequest request = RefundPaymentRequest.builder()
                .paymentId(1L)
                .refundDestinationType(RefundDestinationType.CARD)
                .build();

        PaymentRefundResponse paymentRefundResponse = tokenPay.payment().refundPayment(request);
        assertNotNull(paymentRefundResponse);
        assertEquals(paymentRefundResponse.getPaymentId(), request.getPaymentId());
        assertEquals(paymentRefundResponse.getStatus(), RefundStatus.SUCCESS);
    }

    @Test
    void retrieve_refund_sample() {
        Long paymentRefundId = 1L;

        PaymentRefundResponse paymentRefundResponse = tokenPay.payment().retrievePaymentRefund(paymentRefundId);
        assertNotNull(paymentRefundResponse);
        assertEquals(paymentRefundResponse.getId(), paymentRefundId);
    }

    @Test
    void refund_payment_transaction_sample() {
        RefundPaymentTransactionRequest request = RefundPaymentTransactionRequest.builder()
                .paymentTransactionId(1L)
                .refundPrice(BigDecimal.valueOf(20))
                .refundDestinationType(RefundDestinationType.CARD)
                .conversationId("456d1297-908e-4bd6-a13b-4be31a6e47d5")
                .build();

        PaymentTransactionRefundResponse paymentTransactionRefundResponse = tokenPay.payment().refundPaymentTransaction(request);
        assertNotNull(paymentTransactionRefundResponse);
        assertEquals(paymentTransactionRefundResponse.getPaymentTransactionId(), request.getPaymentTransactionId());
        assertEquals(paymentTransactionRefundResponse.getStatus(), RefundStatus.SUCCESS);
    }

    @Test
    void retrieve_payment_transaction_refund_sample() {
        Long paymentTransactionRefundId = 1L;

        PaymentTransactionRefundResponse paymentTransactionRefundResponse = tokenPay.payment().retrievePaymentTransactionRefund(paymentTransactionRefundId);
        assertNotNull(paymentTransactionRefundResponse);
        assertEquals(paymentTransactionRefundResponse.getId(), paymentTransactionRefundId);
        assertEquals(paymentTransactionRefundResponse.getStatus(), RefundStatus.SUCCESS);
    }

    @Test
    void search_payment_transaction_refund_sample() {
        SearchPaymentTransactionRefundsRequest request = SearchPaymentTransactionRefundsRequest.builder()
                .paymentId(1L)
                .build();

        PaymentTransactionRefundListResponse paymentTransactionRefundListResponse = tokenPay.payment().searchPaymentTransactionRefunds(request);
        assertNotNull(paymentTransactionRefundListResponse);
        assertTrue(paymentTransactionRefundListResponse.getItems().size() > 0);
    }

    @Test
    void send_cross_booking_money_sample() {
        CrossBookingRequest request = CrossBookingRequest.builder()
                .currency(Currency.TRY)
                .price(BigDecimal.valueOf(100))
                .reason("Send Money")
                .subMerchantId(1L)
                .build();

        CrossBookingTransactionResponse crossBookingTransactionResponse = tokenPay.payment().sendMoney(request);
        assertNotNull(crossBookingTransactionResponse);
        assertEquals(crossBookingTransactionResponse.getPrice(), BigDecimal.valueOf(100));
        assertEquals(crossBookingTransactionResponse.getTransactionStatus(), CrossBookingTransactionStatus.WAITING_FOR_PAYOUT);
    }

    @Test
    void receive_cross_booking_money_sample() {
        CrossBookingRequest request = CrossBookingRequest.builder()
                .currency(Currency.TRY)
                .price(BigDecimal.valueOf(100))
                .reason("Receive Money")
                .subMerchantId(1L)
                .build();

        CrossBookingTransactionResponse crossBookingTransactionResponse = tokenPay.payment().receiveMoney(request);
        assertNotNull(crossBookingTransactionResponse);
        assertEquals(crossBookingTransactionResponse.getPrice(), BigDecimal.valueOf(100));
        assertEquals(crossBookingTransactionResponse.getTransactionStatus(), CrossBookingTransactionStatus.WAITING_FOR_PAYOUT);
    }

    @Test
    void cancel_cross_booking_sample() {
        CancelCrossBookingRequest request = CancelCrossBookingRequest.builder()
                .crossBookingId(1L)
                .build();

        CrossBookingTransactionResponse crossBookingTransactionResponse = tokenPay.payment().cancelCrossBooking(request);
        assertNotNull(crossBookingTransactionResponse);
        assertEquals(crossBookingTransactionResponse.getId(), request.getCrossBookingId());
        assertEquals(crossBookingTransactionResponse.getTransactionStatus(), CrossBookingTransactionStatus.CANCELLED);
    }

    @Test
    void cross_booking_search_sample() {
        SearchCrossBookingsRequest request = SearchCrossBookingsRequest.builder()
                .sourceMerchantId(1L)
                .sourceMerchantType(MerchantType.MERCHANT)
                .destinationMerchantId(1L)
                .destinationMerchantType(MerchantType.SUB_MERCHANT)
                .transactionStatus(CrossBookingTransactionStatus.WAITING_FOR_PAYOUT)
                .page(0)
                .size(25)
                .build();

        CrossBookingTransactionListResponse crossBookingTransactionListResponse = tokenPay.payment().searchCrossBookings(request);
        assertNotNull(crossBookingTransactionListResponse);
        assertTrue(crossBookingTransactionListResponse.getItems().size() > 0);
    }

    @Test
    void delete_stored_card_sample() {
        DeleteStoredCardRequest request = DeleteStoredCardRequest.builder()
                .cardUserKey("45012f78-3d68-4d58-902f-d4d858f14d67")
                .cardToken("0ca79029-d805-4e02-97fc-5c599734bc6b")
                .build();

        tokenPay.payment().deleteStoredCard(request);
    }

    @Test
    void search_card_sample() {
        SearchStoredCardsRequest request = SearchStoredCardsRequest.builder()
                .cardAlias("My YKB Card")
                .cardBankName("YAPI VE KREDİ BANKASI A.Ş.")
                .cardBrand("World")
                .cardAssociation(CardAssociation.MASTER_CARD)
                .cardToken("d9b19d1a-243c-43dc-a498-add08162df72")
                .cardUserKey("c115ecdf-0afc-4d83-8a1b-719c2af19cbd")
                .cardType(CardType.CREDIT_CARD)
                .build();

        StoredCardListResponse storedCardListResponse = tokenPay.payment().searchStoredCards(request);
        assertNotNull(storedCardListResponse);
        assertTrue(storedCardListResponse.getItems().size() > 0);
    }
}
