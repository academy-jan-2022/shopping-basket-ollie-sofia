package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class ShoppingBasketServiceShould {

    @Mock IBasketRepository basketRepo;
    private ShoppingBasketService shoppingBasketService;

    @BeforeEach
    void setUp(){
        basketRepo = mock(BasketRepository.class);
        shoppingBasketService = new ShoppingBasketService(basketRepo);
    }

//    @Test
//    void
//    invoke_add_method_on_basket_repo() {
//        var shoppingBasketService = new ShoppingBasketService(basketRepo);
//        shoppingBasketService.addItem(new User(1), new Product(1), 2);
//        verify(basketRepo).add(new User(1), new Product(1), 2);
//    }

    @Test void
    check_if_basket_exists() {
        shoppingBasketService.addItem(new User(1), new Product(1), 2);
        verify(basketRepo).exists(any(User.class));
    }

    @Test void
    creates_basket_if_does_not_exist() {
        when(basketRepo.exists(any(User.class))).thenReturn(false);
        shoppingBasketService.addItem(new User(1), new Product(1), 2);
        verify(basketRepo).createBasket(any(User.class));
    }
}
