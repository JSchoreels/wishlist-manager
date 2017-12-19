package be.jschoreels.services.wishlist.springboot.domain.entity;

import be.jschoreels.services.wishlist.api.domain.Wish;
import be.jschoreels.services.wishlist.api.domain.WishList;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;


/**
 * Created by jschoreels on 11.07.17.
 */
@Entity(name = "wishlist")
@Access(AccessType.FIELD)
public class EntityWishList implements WishList, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(targetEntity=EntityWish.class, cascade = CascadeType.ALL)
    private List<Wish> wishes;

    EntityWishList(){}

    private EntityWishList(final Builder builder) {
        name = builder.name;
        wishes = builder.wishes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final WishList copy) {
        Builder builder = new Builder();
        builder.name = copy.getName();
        builder.wishes = copy.getWishes();
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
    public List<Wish> getWishes() {
        return wishes;
    }

    public static final class Builder {

        private String name;
        private List<Wish> wishes;

        private Builder() {
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withWishes(final List<Wish> wishes) {
            this.wishes = wishes;
            return this;
        }

        public EntityWishList build() {
            return new EntityWishList(this);
        }
    }
}
