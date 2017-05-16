package be.jschoreels.services.wishlist.api.domain;

import java.util.List;

/**
 * Hierarchic collection of {@link Wish}
 */
public interface WishList {

    String getId();

    String getName();

    List<Wish> getWishes();

}
