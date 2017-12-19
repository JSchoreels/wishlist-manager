package be.jschoreels.services.wishlist.springboot.domain.rest;

import be.jschoreels.services.wishlist.api.domain.Priority;
import be.jschoreels.services.wishlist.api.domain.Tag;
import be.jschoreels.services.wishlist.api.domain.Wish;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Set;

/**
 * Created by jschoreels on 27.05.17.
 */
@JsonDeserialize(builder = JacksonWish.Builder.class)
public class JacksonWish implements Wish {

    private final Integer id;
    private final Priority priority;
    private final Set<Tag> tags;
    private final String name;
    private final String description;

    private JacksonWish(final Builder builder) {
        id = builder.id;
        priority = builder.priority;
        tags = builder.tags;
        name = builder.name;
        description = builder.description;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final JacksonWish copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.priority = copy.priority;
        builder.tags = copy.tags;
        builder.name = copy.name;
        builder.description = copy.description;
        return builder;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public Set<Tag> getTags() {
        return tags;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @JsonPOJOBuilder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer id;
        @JsonDeserialize(as = JacksonPriority.class)
        private Priority priority;
        @JsonDeserialize(contentAs = JacksonTag.class)
        private Set<Tag> tags;
        private String name;
        private String description;

        private Builder() {
        }

        public Builder withId(final Integer val) {
            id = val;
            return this;
        }

        public Builder withPriority(final Priority val) {
            priority = val;
            return this;
        }

        public Builder withTags(final Set<Tag> val) {
            tags = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withDescription(final String val) {
            description = val;
            return this;
        }

        public JacksonWish build() {
            return new JacksonWish(this);
        }
    }
}
