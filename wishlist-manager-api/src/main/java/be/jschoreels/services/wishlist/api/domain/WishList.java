package be.jschoreels.services.wishlist.api.domain;

import java.util.List;

/**
 * Hierarchic collection of {@link Wish}
 */
public interface WishList {

    Integer getId();

    String getName();

    List<Wish> getWishes();

}
