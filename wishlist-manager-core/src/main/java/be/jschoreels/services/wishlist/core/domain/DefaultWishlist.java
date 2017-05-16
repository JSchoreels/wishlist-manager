package be.jschoreels.services.wishlist.core.domain;

import be.jschoreels.services.wishlist.api.domain.Wish;
import be.jschoreels.services.wishlist.api.domain.Wishlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hierarchic collection of {@link Wish}
 */
public class DefaultWishlist implements Wishlist {

    private final String id;
    private final String name;
    private final List<Wish> wishes;

    private DefaultWishlist(final Builder builder) {
        id = builder.id;
        name = builder.name;
        wishes = builder.wishes;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Wish> getWishes() {
        return wishes;
    }

    public static Builder create() {
        return new Builder();
    }

    public static Builder copy(final DefaultWishlist copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.wishes = copy.wishes;
        return builder;
    }


    public static final class Builder {
        private String id;
        private String name;
        private List<Wish> wishes;

        private Builder() {
            wishes = new ArrayList<>();
        }

        public Builder withId(final String val) {
            id = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withWishes(final Collection<Wish> val) {
            wishes.addAll(val);
            return this;
        }

        public Builder withWish(final Wish val){
            wishes.add(val);
            return this;
        }

        public DefaultWishlist now() {
            return new DefaultWishlist(this);
        }
    }
}