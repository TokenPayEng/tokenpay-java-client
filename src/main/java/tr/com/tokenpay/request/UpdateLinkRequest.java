package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.Status;
import tr.com.tokenpay.request.common.Request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class UpdateLinkRequest implements Request {

    private Status status;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime expireDate;
    private String enabledInstallments;
}