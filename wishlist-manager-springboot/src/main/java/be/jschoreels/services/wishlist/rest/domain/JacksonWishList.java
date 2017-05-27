package be.jschoreels.services.wishlist.rest.domain;

import be.jschoreels.services.wishlist.api.domain.Wish;
import be.jschoreels.services.wishlist.api.domain.WishList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;

/**
 * Created by jschoreels on 27.05.17.
 */
@JsonDeserialize(builder = JacksonWishList.Builder.class)
public class JacksonWishList implements WishList {

    private final String id;
    private final String name;
    private final List<Wish> wishes;

    private JacksonWishList(final Builder builder) {
        id = builder.id;
        name = builder.name;
        wishes = builder.wishes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final JacksonWishList copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.wishes = copy.wishes;
        return builder;
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

    @JsonPOJOBuilder()
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String id;
        private String name;
        @JsonDeserialize(contentAs = JacksonWish.class)
        private List<Wish> wishes;

        private Builder() {
        }

        public Builder withId(final String val) {
            id = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withWishes(final List<Wish> val) {
            wishes = val;
            return this;
        }

        public JacksonWishList build() {
            return new JacksonWishList(this);
        }
    }
}
