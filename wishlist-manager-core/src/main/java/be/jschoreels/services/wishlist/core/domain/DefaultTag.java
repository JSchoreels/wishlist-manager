package be.jschoreels.services.wishlist.core.domain;

import be.jschoreels.services.wishlist.api.domain.Tag;
import be.jschoreels.services.wishlist.api.domain.Wish;

/**
 * Simple Tag to label {@link Wish}
 */
public class DefaultTag implements Tag {

    private final String name;

    private DefaultTag(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public static DefaultTag withName(String name){
        return new DefaultTag(name);
    }
}
