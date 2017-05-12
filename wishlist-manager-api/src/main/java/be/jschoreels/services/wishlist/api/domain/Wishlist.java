package be.jschoreels.services.wishlist.api.domain;

import java.util.List;

/**
 * Hierarchic collection of {@link Wish}
 */
interface Wishlist {

    String getId();

    String getName();

    List<Wish> getWishes();

}
