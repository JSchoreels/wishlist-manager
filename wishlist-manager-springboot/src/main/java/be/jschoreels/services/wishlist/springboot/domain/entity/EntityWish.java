package be.jschoreels.services.wishlist.springboot.domain.entity;

import be.jschoreels.services.wishlist.api.domain.Wish;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;


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
    @ManyToOne(targetEntity = EntityPriority.class,
        cascade = CascadeType.ALL)
    private EntityPriority priority;
    @ManyToMany(targetEntity = EntityTag.class,
        cascade = CascadeType.ALL)
    private Set<EntityTag> tags;

    EntityWish() {

    }

    private EntityWish(final Builder builder) {
        name = builder.name;
        description = builder.description;
        priority = builder.priority;
        tags = builder.tags;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final Wish copy) {
        Builder builder = new Builder();
        builder.name = copy.getName();
        builder.description = copy.getDescription();
        builder.priority = EntityPriority.newBuilder(copy.getPriority()).build();
        builder.tags = copy.getTags().stream()
            .map(tag -> EntityTag.newBuilder(tag).build())
            .collect(Collectors.toSet());
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
    public EntityPriority getPriority() {
        return priority;
    }

    @Override
    public Set<EntityTag> getTags() {
        return tags;
    }

    public static final class Builder {

        private String name;
        private String description;
        private EntityPriority priority;
        private Set<EntityTag> tags;

        private Builder() {
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withPriority(final EntityPriority priority) {
            this.priority = priority;
            return this;
        }

        public Builder withTags(final Set<EntityTag> tags) {
            this.tags = tags;
            return this;
        }

        public EntityWish build() {
            return new EntityWish(this);
        }
    }
}
