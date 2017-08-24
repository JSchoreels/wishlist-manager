package be.jschoreels.services.wishlist.core.domain;

import be.jschoreels.services.wishlist.api.domain.Wish;
import be.jschoreels.services.wishlist.api.domain.WishList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hierarchic collection of {@link Wish}
 */
public class DefaultWishList implements WishList {

    private final Integer id;
    private final String name;
    private final List<Wish> wishes;

    private DefaultWishList(final Builder builder) {
        id = builder.id;
        name = builder.name;
        wishes = builder.wishes;
    }

    @Override
    public Integer getId() {
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

    public static Builder copy(final DefaultWishList copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.wishes = copy.wishes;
        return builder;
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private List<Wish> wishes;

        private Builder() {
            wishes = new ArrayList<>();
        }

        public Builder withId(final Integer val) {
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

        public DefaultWishList now() {
            return new DefaultWishList(this);
        }
    }
}
