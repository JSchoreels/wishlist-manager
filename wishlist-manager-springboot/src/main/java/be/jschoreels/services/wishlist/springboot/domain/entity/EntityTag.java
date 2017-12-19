package be.jschoreels.services.wishlist.springboot.domain.entity;

import be.jschoreels.services.wishlist.api.domain.Tag;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Created by jschoreels on 11.07.17.
 */
@Entity(name = "tag")
@Access(AccessType.FIELD)
public class EntityTag implements Tag, Serializable {

    @Id
    private final String name;

    public EntityTag(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
