package be.jschoreels.services.wishlist.springboot.service;

import be.jschoreels.services.wishlist.api.domain.Wish;
import be.jschoreels.services.wishlist.api.domain.WishList;
import be.jschoreels.services.wishlist.springboot.domain.entity.EntityWish;
import be.jschoreels.services.wishlist.springboot.domain.entity.EntityWishList;
import be.jschoreels.services.wishlist.springboot.domain.rest.WishlistNotFoundException;
import be.jschoreels.services.wishlist.springboot.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * Created by jschoreels on 11.07.17.
 */
@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;


    public List<WishList> findWishListByName(String name, Pageable pageable){
        return wishListRepository.findByName(name, pageable);
    }

    public Optional<EntityWishList> getWishList(Integer id){
        return wishListRepository.findById(id);
    }

    public List<WishList> getWishLists(Pageable pageable){
        List<WishList> wishLists = new ArrayList<WishList>();
        wishListRepository
            .findAll(pageable)
            .forEach(wishLists::add);
        return wishLists;
    }

    @Transactional
    public Integer createWishList(String name){
        final EntityWishList savedList = wishListRepository.save(
            EntityWishList.newBuilder()
                .withName(name)
                .withWishes(Collections.<Wish>emptyList())
                .build()
        );
        return savedList.getId();
    }


    @Transactional
    public WishList addWishToWishlist(Integer id, Wish wish) {
        final EntityWishList entityWishList = wishListRepository.findById(id).orElseThrow(() -> new WishlistNotFoundException(id));
        entityWishList.getWishes().add(
            EntityWish.newBuilder(wish).build()
        );
        return wishListRepository.save(entityWishList);
    }

}
