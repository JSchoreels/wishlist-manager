package be.jschoreels.services.wishlist.springboot.domain.entity;

import be.jschoreels.services.wishlist.api.domain.Priority;
import be.jschoreels.services.wishlist.api.domain.Tag;
import be.jschoreels.services.wishlist.api.domain.Wish;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Set;


/**
 * Created by jschoreels on 11.07.17.
 */
@Entity(name = "wish")
@Access(AccessType.FIELD)
public class EntityWish implements Wish, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    @OneToOne(targetEntity = EntityPriority.class)
    private Priority priority;
    @OneToMany(targetEntity = EntityTag.class)
    private Set<Tag> tags;

    EntityWish() {

    }

    private EntityWish(final Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        priority = builder.priority;
        tags = builder.tags;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final EntityWish copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.description = copy.description;
        builder.priority = copy.priority;
        builder.tags = copy.tags;
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
        }

        public Builder withId(final Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withPriority(final Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder withTags(final Set<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public EntityWish build() {
            return new EntityWish(this);
        }
    }
}
