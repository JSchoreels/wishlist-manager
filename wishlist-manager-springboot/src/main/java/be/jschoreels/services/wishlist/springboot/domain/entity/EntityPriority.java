package be.jschoreels.services.wishlist.springboot.domain.entity;

import be.jschoreels.services.wishlist.api.domain.Priority;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by jschoreels on 11.07.17.
 */
@Entity(name = "priority")
@Access(AccessType.FIELD)
public class EntityPriority implements Priority {

    @Id
    private final Integer level;

    public EntityPriority(final Integer level) {
        this.level = level;
    }

    @Override
    public Integer getLevel() {
        return level;
    }
}
