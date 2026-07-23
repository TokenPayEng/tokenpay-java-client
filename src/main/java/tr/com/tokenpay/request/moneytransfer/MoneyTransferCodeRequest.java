package tr.com.tokenpay.request.moneytransfer;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import tr.com.tokenpay.request.common.Request;
import tr.com.tokenpay.request.dto.PaymentItem;

import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
public class MoneyTransferCodeRequest implements Request {

    private BigDecimal price;

    private String currency ;

    private String token;

    private String conversationId;

    private String orderId;

    private List<PaymentItem> items;

}