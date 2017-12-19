package be.jschoreels.services.wishlist.springboot;

import be.jschoreels.services.wishlist.springboot.domain.rest.JacksonWishList;
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

    private URL postWishListBase;
    private URL getWishListBase;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        postWishListBase = new URL("http://localhost:" + port + "/wishlist");
        getWishListBase = new URL("http://localhost:" + port + "/wishlists");
    }


    @Test
    public void createAndGetSpecificwishList() throws Exception {
        template.postForEntity(postWishListBase.toString(), "specific", String.class);
        final ResponseEntity<JacksonWishList[]> response = template.getForEntity(getWishListBase + "/specific", JacksonWishList[].class);
        assertThat(response.getBody()[0].getName(), CoreMatchers.equalTo("specific"));
    }

}