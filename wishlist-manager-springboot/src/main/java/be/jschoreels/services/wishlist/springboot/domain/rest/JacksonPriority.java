package be.jschoreels.services.wishlist.springboot.domain.rest;

import be.jschoreels.services.wishlist.api.domain.Priority;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jschoreels on 27.05.17.
 */
public class JacksonPriority implements Priority {

    private final Integer level;

    public JacksonPriority(@JsonProperty(value = "level") final Integer level) {
        this.level = level;
    }

    @Override
    public Integer getLevel() {
        return level;
    }
}
