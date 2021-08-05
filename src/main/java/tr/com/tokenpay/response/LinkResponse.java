package tr.com.tokenpay.response;

import lombok.Data;
import tr.com.tokenpay.model.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LinkResponse {

    private Long id;
    private String name;
    private String description;
    private Status status;
    private BigDecimal price;
    private Integer stock;
    private Integer soldCount;
    private String token;
    private String url;
    private String qrCodeUrl;
    private String enabledInstallments;
    private LocalDateTime expireDate;
}
