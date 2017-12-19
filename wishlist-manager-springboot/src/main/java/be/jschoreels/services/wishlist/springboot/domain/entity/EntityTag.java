package be.jschoreels.services.wishlist.springboot.domain.entity;

import be.jschoreels.services.wishlist.api.domain.Tag;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Created by jschoreels on 11.07.17.
 */
@Entity(name = "tag")
@Access(AccessType.FIELD)
public class EntityTag implements Tag, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public EntityTag() {
    }

    private EntityTag(final Builder builder) {
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final Tag copy) {
        Builder builder = new Builder();
        builder.name = copy.getName();
        return builder;
    }


    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public static final class Builder {

        private String name;

        private Builder() {
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public EntityTag build() {
            return new EntityTag(this);
        }
    }
}
