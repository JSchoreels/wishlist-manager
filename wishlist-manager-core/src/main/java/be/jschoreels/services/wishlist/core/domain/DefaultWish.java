package be.jschoreels.services.wishlist.core.domain;

import be.jschoreels.services.wishlist.api.domain.Priority;
import be.jschoreels.services.wishlist.api.domain.Tag;
import be.jschoreels.services.wishlist.api.domain.Wish;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Wish
 */
public class DefaultWish implements Wish {

    private final Integer id;
    private final String name;
    private final String description;
    private final Priority priority;
    private final Set<Tag> tags;

    private DefaultWish(final Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        priority = builder.priority;
        tags = builder.tags;
    }

    public static Builder create() {
        return new Builder();
    }

    public static Builder copy(final Wish copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.name = copy.getName();
        builder.description = copy.getDescription();
        builder.priority = copy.getPriority();
        builder.tags = Collections.unmodifiableSet(copy.getTags());
        return builder;
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
    public String getDescription() {
        return description;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public Set<Tag> getTags() {
        return tags;
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private String description;
        private Priority priority;
        private Set<Tag> tags;

        private Builder() {
            tags = new HashSet<>();
        }

        public Builder withId(final Integer val) {
            id = val;
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

        public Builder withPriority(final Priority val) {
            priority = val;
            return this;
        }

        public Builder withTags(final Collection<Tag> val) {
            tags.addAll(val);
            return this;
        }

        public Builder withTag(final Tag val){
            tags.add(val);
            return this;
        }

        public DefaultWish now() {
            return new DefaultWish(this);
        }
    }
}
