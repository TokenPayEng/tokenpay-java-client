package tr.com.tokenpay.model;

public enum CrossBookingTransactionStatus {

    WAITING_FOR_PAYOUT,
    PAYOUT_STARTED,
    PAYOUT_COMPLETED,
    NOT_FOUND_IN_SETTLEMENT,
    CANCELLED
}
