package be.jschoreels.services.wishlist.rest;

import be.jschoreels.services.wishlist.rest.domain.JacksonWishList;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by jschoreels on 27.05.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WishListControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        base = new URL("http://localhost:" + port + "/wishlist");
    }

    @Test
    public void getAllWishList() throws Exception {
        final ResponseEntity<JacksonWishList> response = template.getForEntity(base.toString(), JacksonWishList.class);
        assertThat(response.getBody().getName(), CoreMatchers.equalTo("all"));
    }

    @Test
    public void getSpecificwishList() throws Exception {
        final ResponseEntity<JacksonWishList> response = template.getForEntity(base + "?name=specific", JacksonWishList.class);
        assertThat(response.getBody().getName(), CoreMatchers.equalTo("specific"));
    }

}