package be.jschoreels.services.wishlist.springboot.domain.entity;

import be.jschoreels.services.wishlist.api.domain.Priority;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Created by jschoreels on 11.07.17.
 */
@Entity(name = "priority")
@Access(AccessType.FIELD)
public class EntityPriority implements Priority {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer level;

    public EntityPriority() {}

    private EntityPriority(final Builder builder) {
        level = builder.level;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final Priority copy) {
        Builder builder = new Builder();
        builder.level = copy.getLevel();
        return builder;
    }

    @Override
    public Integer getLevel() {
        return level;
    }

    public Integer getId() {
        return id;
    }

    public static final class Builder {

        private Integer level;

        private Builder() {
        }

        public Builder withLevel(final Integer level) {
            this.level = level;
            return this;
        }

        public EntityPriority build() {
            return new EntityPriority(this);
        }
    }
}
