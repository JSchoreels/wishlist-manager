package be.jschoreels.services.wishlist.rest;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by jschoreels on 27.05.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WishListControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DirtiesContext
    public void getDefaultwishList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/wishlist").accept(MediaType.ALL))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json("{\"id\":\"1\",\"name\":\"all\",\"wishes\":[]}"));
    }

    @Test
    @DirtiesContext
    public void getSpecialwishList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/wishlist").param("name", "specialName").accept(MediaType.ALL))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json("{\"id\":\"1\",\"name\":\"specialName\",\"wishes\":[]}"));
    }

}