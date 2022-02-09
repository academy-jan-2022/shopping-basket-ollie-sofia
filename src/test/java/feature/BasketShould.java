package feature;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)

public class BasketShould {
    @Test
    void
    add_an_item_to_the_basket() {
        var shoppingBasketService = new ShoppingBasketService();
        shoppingBasketService.addItem(1, 1, 2);
        var order = new Order();
        verify(order).add(1, 1, 2);
    }
}
