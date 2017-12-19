package be.jschoreels.services.wishlist.springboot.controller;

import be.jschoreels.services.wishlist.api.domain.WishList;
import be.jschoreels.services.wishlist.springboot.service.WishListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by jschoreels on 23.05.17.
 */
@RestController()
public class WishListController {


    private final Logger logger = LoggerFactory.getLogger(WishListController.class);

    private final WishListService wishListService;

    @Autowired
    public WishListController(final WishListService wishListService) {
        this.wishListService = wishListService;
    }

    /**
     * @param name the name of the wishlist to return. by default, "all" is used
     * @return a stub wishlist to test springboot service. Will be linked to persistence later.
     */
    @RequestMapping(value = "wishlists/{name}", method = RequestMethod.GET)
    public List<WishList> getWishList(@PathVariable(value = "name") String name) {
        logger.info("Received a request to retrieve wishlist {}", name);
        return wishListService.getWishList(name);
    }

    @RequestMapping(value = "wishlists", method = RequestMethod.GET)
    public List<WishList> getWishList() {
        logger.info("Received a request to retrieve all wishlists {}");
        return wishListService.getWishLists();
    }

    @RequestMapping(value = "wishlist", method = RequestMethod.POST)
    public Integer postWishList(@RequestBody String name) {
        logger.info("Received a request to create wishlist {}", name);
        return wishListService.createWishList(name);
    }
}
