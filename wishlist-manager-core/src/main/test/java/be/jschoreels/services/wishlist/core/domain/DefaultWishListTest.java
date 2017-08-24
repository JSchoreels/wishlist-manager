package be.jschoreels.services.wishlist.core.domain;

import be.jschoreels.services.wishlist.api.domain.Wish;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

/**
 * Created by jschoreels on 16.05.17.
 */
public class DefaultWishListTest {

    @Test
    public void create() throws Exception {
        final Wish wish1 = Mockito.mock(Wish.class);
        final Wish wish2 = Mockito.mock(Wish.class);
        final Wish wish3 = Mockito.mock(Wish.class);

        final DefaultWishList wishlist = createDefaultWishlist(wish1, wish2, wish3);
        assertTheSameWishList(wish1, wish2, wish3, wishlist);
    }

    private void assertTheSameWishList(final Wish wish1, final Wish wish2, final Wish wish3, final DefaultWishList wishlist) {
        Assert.assertThat(wishlist.getId(), IsEqual.equalTo("id"));
        Assert.assertThat(wishlist.getName(), IsEqual.equalTo("name"));
        Assert.assertThat(wishlist.getWishes(), IsEqual.equalTo(
            Arrays.asList(wish1, wish2, wish3, wish1)
        ));

        Mockito.verifyNoMoreInteractions(wish1, wish2, wish3);
    }

    @Test
    public void copy() throws Exception {
        final Wish wish1 = Mockito.mock(Wish.class);
        final Wish wish2 = Mockito.mock(Wish.class);
        final Wish wish3 = Mockito.mock(Wish.class);

        final DefaultWishList copy = DefaultWishList.copy(createDefaultWishlist(wish1,wish2,wish3)).now();
        assertTheSameWishList(wish1, wish2, wish3, copy);

    }


    private DefaultWishList createDefaultWishlist(final Wish wish1, final Wish wish2, final Wish wish3) {
        return DefaultWishList.create()
            .withId(3)
            .withName("name")
            .withWish(wish1)
            .withWishes(Arrays.asList(wish2, wish3))
            .withWish(wish1)
            .now();
    }

}