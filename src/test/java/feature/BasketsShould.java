package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BasketsShould {

    private Baskets baskets;
    private UserId userId;

    @BeforeEach
    void setUp() {
        this.baskets = new Baskets(new ArrayList<Basket>());
        this.userId = new UserId(1);
    }

    @Test
    void return_false_when_calling_exists_when_no_baskets(){
        var result = baskets.findBasket(userId);
        assertNull(result);
    }

    @Test
    void return_true_when_existing_baskets(){
        var expected = new Basket(userId, "");
        var listOfBaskets = new ArrayList<Basket>();
        listOfBaskets.add(expected);
        var baskets  = new Baskets(listOfBaskets);
        var result = baskets.findBasket(userId);
        assertEquals(expected, result);
    }

    @Test
    void add_basket_to_basket_list(){
        baskets.create(userId);
        var userBasket = baskets.findBasket(userId);
        assertEquals(userId.id(), userBasket.getUserId());
    }

    @Test
    void add_basket_returns_basket(){
        var result = baskets.create(userId);
        var userExists = baskets.findBasket(userId);
        assertInstanceOf(Basket.class, result);
    }

    @Test
    void add_new_item_to_existing_basket(){
        var newBasket = baskets.create(userId);
        baskets.addItem(newBasket, new Item(new ProductId(1), 2));
        var result = baskets.findBasket(userId);
        assertEquals(result.items.size(), 1);
        assertEquals(newBasket, result);
    }

    @Test
    void does_not_add_item_if_basket_does_not_exist(){
        baskets.addItem(new Basket(userId, ""), new Item(new ProductId(1), 2));
        var result = baskets.findBasket(userId);
        assertNull(result);
    }
}
