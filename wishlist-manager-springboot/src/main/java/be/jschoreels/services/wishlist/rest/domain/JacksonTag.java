package be.jschoreels.services.wishlist.rest.domain;

import be.jschoreels.services.wishlist.api.domain.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jschoreels on 27.05.17.
 */
public class JacksonTag implements Tag {

    private final String name;

    public JacksonTag(@JsonProperty(value = "name") final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}


