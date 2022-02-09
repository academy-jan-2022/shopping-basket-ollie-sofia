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

    @Mock
    OrderRepository orderRepository;

    @BeforeEach
    void setUp(){
        orderRepository = mock(DefaultOrderRepository.class);
    }

    @Test
    void
    add_an_item_to_the_basket() {
        var shoppingBasketService = new ShoppingBasketService(orderRepository);
        shoppingBasketService.addItem(1, 1, 2);
        verify(orderRepository).add(1, 1, 2);
    }
}
