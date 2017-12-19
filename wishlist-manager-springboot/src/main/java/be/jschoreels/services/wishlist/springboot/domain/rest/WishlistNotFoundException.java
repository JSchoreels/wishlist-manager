package be.jschoreels.services.wishlist.springboot.domain.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WishlistNotFoundException extends RuntimeException {

    public WishlistNotFoundException(final Integer id){
        super("No wishlist found with ID " + id);
    }

}
