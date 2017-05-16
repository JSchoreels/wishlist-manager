package be.jschoreels.services.wishlist.core.domain;

import be.jschoreels.services.wishlist.api.domain.Tag;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jschoreels on 16.05.17.
 */
public class DefaultWishTest {
    @Test
    public void create() throws Exception {
        final DefaultWish defaultWish = createDefaultWish();
        assertTheSameWish(defaultWish);
    }

    private void assertTheSameWish(final DefaultWish defaultWish) {
        Assert.assertEquals("description", defaultWish.getDescription());
        Assert.assertEquals("id", defaultWish.getId());
        Assert.assertEquals("name", defaultWish.getName());
        Assert.assertEquals(new Integer(2), defaultWish.getPriority().getLevel());
        Assert.assertThat(
            defaultWish.getTags().stream()
                .map(Tag::getName)
                .collect(Collectors.toList()),
            IsCollectionContaining.hasItems(
                "Tag1", "Tag2", "Tag3", "Tag4"
            ));
    }

    @Test
    public void copy() throws Exception {
        final DefaultWish copy = DefaultWish.copy(createDefaultWish()).now();
        assertTheSameWish(copy);
    }


    public static DefaultWish createDefaultWish() {
        return DefaultWish.create()
            .withDescription("description")
            .withId("id")
            .withName("name")
            .withPriority(
                DefaultPriority.withLevel(2))
            .withTag(
                DefaultTag.withName("Tag1"))
            .withTags(
                Arrays.asList(
                    DefaultTag.withName("Tag2"),
                    DefaultTag.withName("Tag3"))
            )
            .withTag(
                DefaultTag.withName("Tag4")
            )
            .now();
    }

}