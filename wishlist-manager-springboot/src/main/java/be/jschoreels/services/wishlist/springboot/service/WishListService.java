package be.jschoreels.services.wishlist.springboot.service;

import be.jschoreels.services.wishlist.api.domain.Wish;
import be.jschoreels.services.wishlist.api.domain.WishList;
import be.jschoreels.services.wishlist.springboot.domain.entity.EntityWishList;
import be.jschoreels.services.wishlist.springboot.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by jschoreels on 11.07.17.
 */
@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;


    public Integer createWishList(String name){
        final EntityWishList savedList = wishListRepository.save(
            EntityWishList.newBuilder()
                .withName(name)
                .withWishes(Collections.<Wish>emptyList())
                .build()
        );
        return savedList.getId();
    }

    public List<WishList> getWishList(String name){
        return wishListRepository.findByName(name);
    }

    public List<WishList> getWishLists(){
        List<WishList> wishLists = new ArrayList<WishList>();
        wishListRepository
            .findAll()
            .forEach(wishLists::add);
        return wishLists;
    }

}
