package be.jschoreels.services.wishlist.rest;

import be.jschoreels.services.wishlist.api.domain.WishList;
import be.jschoreels.services.wishlist.core.domain.DefaultWishList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jschoreels on 23.05.17.
 */
@RestController()
public class WishListController {


    private final Logger logger = LoggerFactory.getLogger(WishListController.class);

    private final AtomicLong counter = new AtomicLong(0l);

    /**
     *
     * @param name the name of the wishlist to return. by default, "all" is used
     * @return a stub wishlist to test rest service. Will be linked to persistence later.
     */
    @RequestMapping(value = "wishlist", method = RequestMethod.GET)
    public WishList wishList (@RequestParam(value = "name", defaultValue = "all") String name){
        logger.info("Received a request to retrieve wishlist {}", name);
        return DefaultWishList.create()
            .withId(String.valueOf(counter.incrementAndGet()))
            .withName(name)
            .now();
    }
}
