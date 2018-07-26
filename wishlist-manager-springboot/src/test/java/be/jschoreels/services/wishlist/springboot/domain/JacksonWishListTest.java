package be.jschoreels.services.wishlist.springboot.domain;

import be.jschoreels.services.wishlist.api.domain.Tag;
import be.jschoreels.services.wishlist.api.domain.WishList;
import be.jschoreels.services.wishlist.core.domain.DefaultPriority;
import be.jschoreels.services.wishlist.core.domain.DefaultTag;
import be.jschoreels.services.wishlist.core.domain.DefaultWish;
import be.jschoreels.services.wishlist.core.domain.DefaultWishList;
import be.jschoreels.services.wishlist.springboot.domain.rest.JacksonWishList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jschoreels on 27.05.17.
 */
public class JacksonWishListTest {


    @Test
    public void testDeserialization() throws Exception {

        final DefaultWishList inputPOJO = createDefaultWishlist();

        ObjectMapper objectMapper = new ObjectMapper();
        final String inputString = objectMapper.writeValueAsString(inputPOJO);

        final JacksonWishList jacksonWishList = objectMapper.readValue(inputString, JacksonWishList.class);

        assertThat(inputPOJO.getId(), CoreMatchers.equalTo(jacksonWishList.getId()));
        assertThat(inputPOJO.getName(), CoreMatchers.equalTo(jacksonWishList.getName()));
        assertThat(inputPOJO.getWishes().size(), CoreMatchers.equalTo(jacksonWishList.getWishes().size()));
        assertThat(inputPOJO.getWishes().get(0).getDescription(), CoreMatchers.equalTo(jacksonWishList.getWishes().get(0).getDescription()));
        assertThat(inputPOJO.getWishes().get(0).getId(), CoreMatchers.equalTo(jacksonWishList.getWishes().get(0).getId()));
        assertThat(inputPOJO.getWishes().get(0).getPriority().getLevel(), CoreMatchers.equalTo(jacksonWishList.getWishes().get(0).getPriority().getLevel()));

    }

    @Test
    public void testXmlDeserialization() throws Exception {
        final WishList inputPOJO = createDefaultWishlist();

        XmlMapper xmlMapper = new XmlMapper();
        final String xmlWishlist = xmlMapper.writeValueAsString(inputPOJO);

        final JacksonWishList jacksonWishList = xmlMapper.readValue(xmlWishlist, JacksonWishList.class);

        assertThat(inputPOJO.getId(), CoreMatchers.equalTo(jacksonWishList.getId()));
        assertThat(inputPOJO.getName(), CoreMatchers.equalTo(jacksonWishList.getName()));
        assertThat(inputPOJO.getWishes().size(), CoreMatchers.equalTo(jacksonWishList.getWishes().size()));
        assertThat(inputPOJO.getWishes().get(0).getDescription(), CoreMatchers.equalTo(jacksonWishList.getWishes().get(0).getDescription()));
        assertThat(inputPOJO.getWishes().get(0).getId(), CoreMatchers.equalTo(jacksonWishList.getWishes().get(0).getId()));
        assertThat(inputPOJO.getWishes().get(0).getPriority().getLevel(), CoreMatchers.equalTo(jacksonWishList.getWishes().get(0).getPriority().getLevel()));
    }

    private DefaultWishList createDefaultWishlist() {
        return DefaultWishList.create()
            .withId(1)
            .withName("name")
            .withWish(createDefaultWish())
            .now();
    }

    public static DefaultWish createDefaultWish() {
        return DefaultWish.create()
            .withDescription("description")
            .withId(1)
            .withName("name")
            .withPriority(
                DefaultPriority.withLevel(2))
            .withTag(
                DefaultTag.withName("Tag1"))
            .withTags(
                Arrays.<Tag>asList(
                    DefaultTag.withName("Tag2"),
                    DefaultTag.withName("Tag3"))
            )
            .withTag(
                DefaultTag.withName("Tag4")
            )
            .now();
    }


}