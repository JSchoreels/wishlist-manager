package be.jschoreels.services.wishlist.springboot.repository;

import be.jschoreels.services.wishlist.api.domain.WishList;
import be.jschoreels.services.wishlist.springboot.domain.entity.EntityWishList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by jschoreels on 11.07.17.
 */
public interface WishListRepository extends CrudRepository<EntityWishList, String> {

    List<WishList> findByName(String name);

}
