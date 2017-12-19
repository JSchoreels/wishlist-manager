package be.jschoreels.services.wishlist.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;


/**
 * Created by jschoreels on 23.05.17.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
