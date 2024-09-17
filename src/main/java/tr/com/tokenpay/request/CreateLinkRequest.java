package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.request.common.Request;
import tr.com.tokenpay.request.dto.PaymentItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CreateLinkRequest implements Request {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime expireDate;
    private String enabledInstallments;
    private String conversationId;
    private List<PaymentItem> items;
    private String merchantBranchName;
}