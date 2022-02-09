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
    BasketRepository basketRepository;

    @BeforeEach
    void setUp(){
        basketRepository = mock(DefaultBasketRepository.class);
    }

    @Test
    void
    add_an_item_to_the_basket() {
        var shoppingBasketService = new ShoppingBasketService(basketRepository);
        shoppingBasketService.addItem(new BasketItem(1, 1,2));
        verify(basketRepository).add(new BasketItem(1, 1,2));
    }
}
