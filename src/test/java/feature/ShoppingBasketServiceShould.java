package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class ShoppingBasketServiceShould {

    @Mock Order order;

    @BeforeEach
    void setUp(){
        order = mock(Order.class);
    }

    @Test
    void
    add_an_item_to_the_basket() {
        var shoppingBasketService = new ShoppingBasketService(order);
        shoppingBasketService.addItem(1, 1, 2);
        verify(order).add(1, 1, 2);
    }
}
