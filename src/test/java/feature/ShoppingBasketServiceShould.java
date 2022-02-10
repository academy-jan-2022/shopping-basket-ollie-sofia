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
    add_item_when_basket_exists() {
        shoppingBasketService.addItem(new UserId(1), new ProductId(2), 1);
        verify(basketRepo).addUserItem(any(UserId.class), any(ProductId.class), anyInt());
    }

    @Test void
    return_a_users_basket_with_correct_items(){
        shoppingBasketService.basketFor(userId);
        verify(basketRepo).getByUserId(any(UserId.class));
    }
}
