package tr.com.tokenpay.request;

import lombok.Builder;
import lombok.Data;
import tr.com.tokenpay.model.SubMerchantType;
import tr.com.tokenpay.request.common.Request;

@Data
@Builder
public class CreateSubMerchantRequest implements Request {

    private SubMerchantType subMerchantType;
    private String subMerchantExternalId;
    private String name;
    private String address;
    private String email;
    private String iban;
    private String gsmNumber;
    private String taxOffice;
    private String taxNumber;
    private String contactName;
    private String contactSurname;
    private String identityNumber;
    private String legalCompanyTitle;
}
