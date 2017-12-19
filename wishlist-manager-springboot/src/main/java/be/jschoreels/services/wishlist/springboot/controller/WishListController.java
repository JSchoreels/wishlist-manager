package be.jschoreels.services.wishlist.springboot.controller;

import be.jschoreels.services.wishlist.api.domain.Wish;
import be.jschoreels.services.wishlist.api.domain.WishList;
import be.jschoreels.services.wishlist.springboot.domain.entity.EntityWishList;
import be.jschoreels.services.wishlist.springboot.domain.rest.JacksonWish;
import be.jschoreels.services.wishlist.springboot.domain.rest.WishlistNotFoundException;
import be.jschoreels.services.wishlist.springboot.service.WishListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;


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

    @RequestMapping(value = "wishlists/search", method = RequestMethod.GET)
    public List<WishList> getWishLists(@RequestParam(value = "name", defaultValue = "all") String name,
                                       Pageable pageable) {
        logger.info("Received a request to search all wishlists with name \"{}\"", name);
        return wishListService.findWishListByName(name, pageable);
    }

    @RequestMapping(value = "wishlists/{id}", method = RequestMethod.GET)
    public EntityWishList getWishList(@PathVariable(value = "id") Integer id) {
        logger.info("Received a request to retrieve wishlist with name \"{}\"", id);
        return wishListService
            .getWishList(id)
            .orElseThrow(() -> new WishlistNotFoundException(id));
    }

    @RequestMapping(value = "wishlists", method = RequestMethod.GET)
    public List<WishList> getWishLists(Pageable pageable) {
        logger.info("Received a request to search all wishlists");
        return wishListService.getWishLists(pageable);
    }

    @RequestMapping(value = "wishlist", method = RequestMethod.POST)
    public Integer postWishList(@RequestBody String name) {
        logger.info("Received a request to create wishlist {}", name);
        return wishListService.createWishList(name);
    }

    @RequestMapping(value = "wishlist/{id}/wishes", method = RequestMethod.POST)
    public WishList postWishInWishList(@PathVariable(name = "id") Integer id,
                                       @RequestBody JacksonWish wish) {
        logger.info("Received a request to create new wish {} in wishlist of id {}", wish, id);
        return wishListService.addWishToWishlist(id, wish);
    }
}
