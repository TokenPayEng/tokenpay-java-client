package tr.com.tokenpay.sample;

import org.junit.jupiter.api.Test;
import tr.com.tokenpay.TokenPay;
import tr.com.tokenpay.model.SubMerchantType;
import tr.com.tokenpay.request.*;
import tr.com.tokenpay.response.BuyerResponse;
import tr.com.tokenpay.response.SubMerchantListResponse;
import tr.com.tokenpay.response.SubMerchantResponse;

import java.util.HashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class OnboardingSample {

    private final TokenPay tokenPay = new TokenPay("api-key", "secret-key", "http://localhost:8000");

    @Test
    void create_sub_merchant() {
        CreateSubMerchantRequest request = CreateSubMerchantRequest.builder()
                .contactName("Haluk")
                .contactSurname("Demir")
                .email("haluk.demir@example.com")
                .gsmNumber("905551111111")
                .iban("TR930006701000000001111111")
                .identityNumber("11111111110")
                .legalCompanyTitle("Dem Zeytinyağı Üretim Ltd. Şti.")
                .name("Dem Zeytinyağı Üretim Ltd. Şti.")
                .subMerchantExternalId(UUID.randomUUID().toString())
                .subMerchantType(SubMerchantType.LIMITED_OR_JOINT_STOCK_COMPANY)
                .taxNumber("1111111114")
                .taxOffice("Erenköy")
                .address("Suadiye Mah. Örnek Cd. No:23, 34740 Kadıköy/İstanbul")
                .build();

        SubMerchantResponse response = tokenPay.onboarding().createSubMerchant(request);
        assertNotNull(response.getId());
        assertEquals(request.getContactName(), response.getContactName());
        assertEquals(request.getContactSurname(), response.getContactSurname());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getGsmNumber(), response.getGsmNumber());
        assertEquals(request.getIban(), response.getIban());
        assertEquals(request.getIdentityNumber(), response.getIdentityNumber());
        assertEquals(request.getLegalCompanyTitle(), response.getLegalCompanyTitle());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getSubMerchantExternalId(), response.getSubMerchantExternalId());
        assertEquals(request.getSubMerchantType(), response.getSubMerchantType());
        assertEquals(request.getTaxNumber(), response.getTaxNumber());
        assertEquals(request.getTaxOffice(), response.getTaxOffice());
        assertEquals(request.getAddress(), response.getAddress());
    }

    @Test
    void update_sub_merchant() {
        Long subMerchantId = 1L;

        UpdateSubMerchantRequest request = UpdateSubMerchantRequest.builder()
                .contactName("Haluk")
                .contactSurname("Demir")
                .email("haluk.demir@example.com")
                .gsmNumber("905551111111")
                .iban("TR930006701000000001111111")
                .identityNumber("11111111110")
                .legalCompanyTitle("Dem Zeytinyağı Üretim Ltd. Şti.")
                .name("Dem Zeytinyağı Üretim Ltd. Şti.")
                .taxNumber("1111111114")
                .taxOffice("Erenköy")
                .address("Suadiye Mah. Örnek Cd. No:23, 34740 Kadıköy/İstanbul")
                .build();

        SubMerchantResponse response = tokenPay.onboarding().updateSubMerchant(subMerchantId, request);
        assertEquals(subMerchantId, response.getId());
        assertEquals(request.getContactName(), response.getContactName());
        assertEquals(request.getContactSurname(), response.getContactSurname());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getGsmNumber(), response.getGsmNumber());
        assertEquals(request.getIban(), response.getIban());
        assertEquals(request.getIdentityNumber(), response.getIdentityNumber());
        assertEquals(request.getLegalCompanyTitle(), response.getLegalCompanyTitle());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getTaxNumber(), response.getTaxNumber());
        assertEquals(request.getTaxOffice(), response.getTaxOffice());
        assertEquals(request.getAddress(), response.getAddress());
    }

    @Test
    void retrieve_sub_merchant() {
        Long subMerchantId = 1L;

        SubMerchantResponse response = tokenPay.onboarding().retrieveSubMerchant(subMerchantId);
        assertEquals(subMerchantId, response.getId());
    }

    @Test
    void search_sub_merchants() {
        HashSet<Long> subMerchantIds = new HashSet<Long>() {{
            add(1L);
            add(2L);
        }};

        SearchSubMerchantsRequest request = SearchSubMerchantsRequest.builder()
                .subMerchantIds(subMerchantIds)
                .name("Zeytinyağı Üretim")
                .build();

        SubMerchantListResponse response = tokenPay.onboarding().searchSubMerchants(request);
        assertTrue(response.getItems().size() > 0);
    }

    @Test
    void create_buyer() {
        CreateBuyerRequest request = CreateBuyerRequest.builder()
                .buyerExternalId(UUID.randomUUID().toString())
                .email("haluk.demir@example.com")
                .gsmNumber("905551111111")
                .name("Haluk")
                .surname("Demir")
                .identityNumber("11111111110")
                .build();

        BuyerResponse response = tokenPay.onboarding().createBuyer(request);
        assertNotNull(response.getId());
        assertEquals(request.getBuyerExternalId(), response.getBuyerExternalId());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getGsmNumber(), response.getGsmNumber());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getSurname(), response.getSurname());
        assertEquals(request.getIdentityNumber(), response.getIdentityNumber());
    }

    @Test
    void update_buyer() {
        Long buyerId = 1L;

        UpdateBuyerRequest request = UpdateBuyerRequest.builder()
                .email("haluk.demir@example.com")
                .gsmNumber("905551111111")
                .name("Haluk")
                .surname("Demir")
                .identityNumber("11111111110")
                .build();

        BuyerResponse response = tokenPay.onboarding().updateBuyer(buyerId, request);
        assertEquals(buyerId, response.getId());
        assertEquals(request.getEmail(), response.getEmail());
        assertEquals(request.getGsmNumber(), response.getGsmNumber());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getSurname(), response.getSurname());
        assertEquals(request.getIdentityNumber(), response.getIdentityNumber());
    }

    @Test
    void retrieve_buyer() {
        Long buyerId = 1L;

        BuyerResponse response = tokenPay.onboarding().retrieveBuyer(buyerId);
        assertEquals(buyerId, response.getId());
    }
}