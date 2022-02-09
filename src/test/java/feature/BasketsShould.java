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
        var result = baskets.findBasket(user);
        assertNull(result);
    }

    @Test
    void return_true_when_existing_baskets(){
        var expected = new Basket(user);
        var listOfBaskets = new ArrayList<Basket>();
        listOfBaskets.add(expected);
        var baskets  = new Baskets(listOfBaskets);
        var result = baskets.findBasket(user);
        assertEquals(expected, result);
    }

    @Test
    void add_basket_to_basket_list(){
        baskets.create(user);
        var userBasket = baskets.findBasket(user);
        assertEquals(user, userBasket.user());
    }

    @Test
    void add_basket_returns_basket(){
        var result = baskets.create(user);
        var userExists = baskets.findBasket(user);
        assertInstanceOf(Basket.class, result);
    }
}
