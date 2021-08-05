package tr.com.tokenpay.sample;

import org.junit.jupiter.api.Test;
import tr.com.tokenpay.TokenPay;
import tr.com.tokenpay.model.Status;
import tr.com.tokenpay.request.CreateLinkRequest;
import tr.com.tokenpay.request.SearchLinksRequest;
import tr.com.tokenpay.request.UpdateLinkRequest;
import tr.com.tokenpay.response.LinkListResponse;
import tr.com.tokenpay.response.LinkResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LinkSample {

    private final TokenPay tokenPay = new TokenPay("api-key", "secret-key", "https://api-gateway.tokenpay.com.tr");

    @Test
    void create_link() {
        CreateLinkRequest createLinkRequest = CreateLinkRequest.builder()
                .name("test link")
                .description("Test Link for payment")
                .price(BigDecimal.TEN)
                .stock(100)
                .enabledInstallments("1,2,3,6")
                .expireDate(LocalDateTime.now().plusYears(20))
                .build();

        LinkResponse link = tokenPay.link().createLink(createLinkRequest);
        assertNotNull(link.getId());
    }

    @Test
    void update_link() {
        Long id = 1L;
        UpdateLinkRequest createLinkRequest = UpdateLinkRequest.builder()
                .status(Status.ACTIVE)
                .name("new test link")
                .description("new Test Link for payment")
                .price(BigDecimal.TEN)
                .stock(100)
                .enabledInstallments("1,2")
                .expireDate(LocalDateTime.now().plusYears(2))
                .build();

        LinkResponse link = tokenPay.link().updateLink(id, createLinkRequest);
        assertNotNull(link.getId());
    }

    @Test
    void retrieve_link() {
        Long id = 65L;

        LinkResponse link = tokenPay.link().retrieve(id);
        assertNotNull(link.getId());
    }

    @Test
    void delete_link() {
        Long id = 65L;

        tokenPay.link().delete(id);
    }

    @Test
    void search_links() {
        SearchLinksRequest searchLinksRequest = SearchLinksRequest.builder()
                .status(Status.ACTIVE)
                .name("name")
                .token("token")
                .build();

        LinkListResponse response = tokenPay.link().search(searchLinksRequest);
        assertEquals(response.getItems().size(), 0);
    }
}
