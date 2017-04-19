package be.jschoreels.services.wishlist.api.domain;

import java.util.List;

/**
 * Created by jschoreels on 19.04.17.
 */
interface Wishlist {

    String getId();

    String getName();

    List<Wish> getWishes();

}
