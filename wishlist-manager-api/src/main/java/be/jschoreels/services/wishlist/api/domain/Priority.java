package be.jschoreels.services.wishlist.api.domain;

import java.time.ZonedDateTime;

/**
 * Created by jschoreels on 12.05.17.
 */
public interface Priority {

    /**
     *
     * @return The Priority Level. if priority a.getLevel > b.getLevel, a is a higher priority than b
     */
    Integer getLevel();

    /**
     * Computes to compute the level of priority at a certain date, allowing to make implements priority
     * @param zonedDateTime the ZonedDateTime when the priority must be evaluated
     * @return the Priority Level at this moment. By default it uses the base priority level.
     */
    default Integer getLevel(ZonedDateTime zonedDateTime){
        return getLevel();
    }

}
