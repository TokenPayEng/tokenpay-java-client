package com.tokenpay.response;

import com.tokenpay.model.RefundDestinationType;
import com.tokenpay.model.RefundStatus;
import com.tokenpay.model.RefundType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class RefundResponse {

    private Long id;
    private String conversationId;
    private Date createdDate;
    private RefundStatus status;
    private BigDecimal refundPrice;
    private BigDecimal refundBankPrice;
    private BigDecimal refundWalletPrice;
    private RefundType refundType;
    private RefundDestinationType refundDestinationType;
    private String currency;
    private Long paymentId;
    private List<RefundTxResponse> paymentTxRefunds;
}