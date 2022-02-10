package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

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
        shoppingBasketService.addItem(userId, new ProductId(2), 1);
        verify(basketRepo).addUserItem(any(UserId.class), any(ProductId.class), anyInt());
    }

   @Test void
    request_user_basket_items(){
        shoppingBasketService.basketFor(userId);
        verify(basketRepo).getUserItems(userId);
   }

   @Test void
    check_list_contain_items() {
       var expectedItems = new ProductQuantity[]{new ProductQuantity(new ProductId(1), 1), new ProductQuantity(new ProductId(2), 1), new ProductQuantity(new ProductId(3), 1)};

        var expected = new ArrayList<ProductQuantity>(Arrays.asList(expectedItems));
        when(basketRepo.getUserItems(any(UserId.class))).thenReturn(expected);

        var result = shoppingBasketService.basketFor(userId);
        assertEquals(expected, result);
   }
}
