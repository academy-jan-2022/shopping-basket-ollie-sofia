package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class ShoppingBasketServiceShould {

    @Mock IBasketRepository basketRepo;
    private ShoppingBasketService shoppingBasketService;
    private UserId userId;

    @BeforeEach
    void setUp(){
        basketRepo = mock(BasketRepository.class);
        shoppingBasketService = new ShoppingBasketService(basketRepo);
        userId = new UserId(1);
    }


    @Test void
    check_if_basket_exists() {
        shoppingBasketService.addItem(new UserId(1), new ProductId(1), 2);
        verify(basketRepo).getByUserId(any(UserId.class));
    }

    @Test void
    creates_basket_if_does_not_exist() {
        when(basketRepo.getByUserId(any(UserId.class))).thenReturn(null);
        shoppingBasketService.addItem(new UserId(1), new ProductId(1), 2);
        verify(basketRepo).createBasket(any(UserId.class));
    }

    @Test void
    add_item_when_basket_exists() {
        when(basketRepo.getByUserId(any(UserId.class))).thenReturn(new Basket(new UserId(1), ""));
        shoppingBasketService.addItem(new UserId(1), new ProductId(2), 1);
        verify(basketRepo).addItem(any(Basket.class), any(Item.class));
    }

    @Test void
    return_a_users_basket_with_correct_items(){
        shoppingBasketService.basketFor(userId);
        verify(basketRepo).getByUserId(any(UserId.class));
    }
}
