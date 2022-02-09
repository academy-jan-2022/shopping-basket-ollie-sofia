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

    @Mock IBasketRepository basketRepo;

    @BeforeEach
    void setUp(){
        basketRepo = mock(BasketRepository.class);
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
        var shoppingBasketService = new ShoppingBasketService(basketRepo);
        shoppingBasketService.addItem(new User(1), new Product(1), 2);
       verify(basketRepo).exists();
    }
}
