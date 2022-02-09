package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class ShoppingBasketServiceShould {

    @Mock
    BasketRepository basketRepository;
    private ShoppingBasketService shoppingBasketService;

    @BeforeEach
    void setUp(){
        basketRepository = mock(DefaultBasketRepository.class);
        this.shoppingBasketService = new ShoppingBasketService(basketRepository);
    }

    @Test
    void
    add_an_item_to_the_basket() {
        shoppingBasketService.addItem(new BasketItem(1, 1,2));
        verify(basketRepository).add(new BasketItem(1, 1,2));
    }

    @Test
    void
    return_a_basket(){
        var result = shoppingBasketService.basketFor(1);
        assertTrue(result instanceof Basket);
    }

    @Test void
    return_basket_of_user_id_1() {
        var result = shoppingBasketService.basketFor(1);
        assertEquals(result.userId, 1);
    }
}
