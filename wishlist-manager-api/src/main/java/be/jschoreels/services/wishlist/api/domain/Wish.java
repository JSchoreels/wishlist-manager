package be.jschoreels.services.wishlist.api.domain;

import java.util.Set;

/**
 * Represents a Wish
 */
interface Wish {

    String getId();

    String getName();

    String getDescription();

    Priority getPriority();

    Set<Tag> getTags();


}
