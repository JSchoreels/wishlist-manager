package be.jschoreels.services.wishlist.api.domain;

import java.util.Set;

/**
 * Represents a Wish
 */
public interface Wish {

    Integer getId();

    String getName();

    String getDescription();

    Priority getPriority();

    Set<? extends Tag> getTags();


}
