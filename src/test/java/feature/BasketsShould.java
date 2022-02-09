package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BasketsShould {

    private Baskets baskets;
    private User user;

    @BeforeEach
    void setUp() {
        this.baskets = new Baskets(new ArrayList<Basket>());
        this.user = new User(1);
    }

    @Test
    void return_false_when_calling_exists_when_no_baskets(){
        var expected = false;
        var result = baskets.exists(user);
        assertEquals(expected, result);
    }

    @Test
    void return_true_when_existing_baskets(){
        var expected = true;
        var listOfBaskets = new ArrayList<Basket>();
        listOfBaskets.add(new Basket(user));
        var baskets  = new Baskets(listOfBaskets);
        var result = baskets.exists(user);
        assertEquals(expected, result);
    }

    @Test
    void add_basket_to_basket_list(){
        baskets.add(user);
        var userExists = baskets.exists(user);
        assertTrue(userExists);
    }

    @Test
    void add_basket_returns_basket(){
        var result = baskets.add(user);
        var userExists = baskets.exists(user);
        assertInstanceOf(Basket.class, result);
    }
}
