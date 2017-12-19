package be.jschoreels.services.wishlist.springboot.repository;

import be.jschoreels.services.wishlist.api.domain.WishList;
import be.jschoreels.services.wishlist.springboot.domain.entity.EntityWishList;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


/**
 * Created by jschoreels on 11.07.17.
 */
public interface WishListRepository extends PagingAndSortingRepository<EntityWishList, Integer> {

    List<WishList> findByName(String name);

    List<WishList> findByName(String name, Pageable pageable);

}
