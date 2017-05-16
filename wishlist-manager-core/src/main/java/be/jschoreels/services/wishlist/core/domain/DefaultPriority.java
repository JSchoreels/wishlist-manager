package be.jschoreels.services.wishlist.core.domain;

import be.jschoreels.services.wishlist.api.domain.Priority;

import java.time.ZonedDateTime;

/**
 * Created by jschoreels on 12.05.17.
 */
public class DefaultPriority implements Priority {

    private final Integer level;

    private DefaultPriority(final Integer level) {
        this.level = level;
    }

    @Override
    public Integer getLevel() {
        return level;
    }

    public static DefaultPriority withLevel(Integer level){
        return new DefaultPriority(level);
    }
}
