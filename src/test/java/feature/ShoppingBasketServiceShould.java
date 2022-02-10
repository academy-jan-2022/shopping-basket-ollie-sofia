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
    private User user;

    @BeforeEach
    void setUp(){
        basketRepo = mock(BasketRepository.class);
        shoppingBasketService = new ShoppingBasketService(basketRepo);
        user = new User(1);
    }


    @Test void
    check_if_basket_exists() {
        shoppingBasketService.addItem(new User(1), new Product(1), 2);
        verify(basketRepo).getByUserId(any(User.class));
    }

    @Test void
    creates_basket_if_does_not_exist() {
        when(basketRepo.getByUserId(any(User.class))).thenReturn(null);
        shoppingBasketService.addItem(new User(1), new Product(1), 2);
        verify(basketRepo).createBasket(any(User.class));
    }

    @Test void
    add_item_when_basket_exists() {
        when(basketRepo.getByUserId(any(User.class))).thenReturn(new Basket(new User(1)));
        shoppingBasketService.addItem(new User(1), new Product(2), 1);
        verify(basketRepo).addItem(any(Basket.class), any(Item.class));
    }

    @Test void
    return_a_users_basket_with_expected_user_id(){
        var user = new User(1);
        var result = shoppingBasketService.basketFor(user);
        assertEquals(user.id(), result.getUserId());
    }

    @Test void
    returns_a_users_basket_with_correct_items(){
        shoppingBasketService.addItem(user, new Product(1), 3);
        var result = shoppingBasketService.basketFor(user);
        var resultItem = result.items.get(0);
        assertEquals(user.id(), result.getUserId());
        assertEquals(1, resultItem.product().id());
        assertEquals(3, resultItem.quantity());
    }
}
