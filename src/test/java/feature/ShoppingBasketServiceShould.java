package feature;

import feature.Domain.BasketItem;
import feature.Domain.ProductId;
import feature.Domain.UserId;
import feature.Infrastructure.Providers.DateProvider;
import feature.Repositories.BasketRepositoryInMem;
import feature.Repositories.Interfaces.BasketRepository;
import feature.Repositories.Interfaces.ProductRepository;
import feature.Repositories.ProductRepositoryInMem;
import feature.Services.ShoppingBasketService;
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

    @Mock
    BasketRepository basketRepo;
    private ShoppingBasketService shoppingBasketService;
    private UserId userId;
    private BasketItem[] expectedItems;
    private DateProvider dateProvider;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        basketRepo = mock(BasketRepositoryInMem.class);
        dateProvider = mock(DateProvider.class);
        shoppingBasketService = new ShoppingBasketService(basketRepo, dateProvider);
        userId = new UserId(1);
        expectedItems = new BasketItem[]{new BasketItem(new ProductId(1), 1, "01/01/2021"),
                new BasketItem(new ProductId(2), 1, ""), new BasketItem(new ProductId(3), 1, "")};
        productRepository = new ProductRepositoryInMem();

    }

    @Test void
    add_item_when_basket_exists() {
        shoppingBasketService.addItem(userId, new ProductId(2), 1);
        verify(basketRepo).addUserItem(any(UserId.class), any(ProductId.class), anyInt(), anyString());
    }

   @Test void
    request_user_basket_items(){
        shoppingBasketService.basketFor(userId);
        verify(basketRepo).getUserItems(userId);
   }

   @Test void
    check_list_contain_items() {
        var expected = new ArrayList<BasketItem>(Arrays.asList(expectedItems));
        when(basketRepo.getUserItems(any(UserId.class))).thenReturn(expected);

        var result = shoppingBasketService.basketFor(userId);
        assertEquals(expected.size(), result.entries().size());
   }

    @Test void
    return_basket_with_correct_date_when_contains_1_item() {
        var expected = new ArrayList<BasketItem>(Arrays.asList(expectedItems[0]));
        when(basketRepo.getUserItems(any(UserId.class))).thenReturn(expected);

        var result = shoppingBasketService.basketFor(userId);
        assertEquals(expected.get(0).dateAdded(), result.createdAt());
    }

    @Test void
    return_basket_with_correct_date_when_contains_multiple_items(){
        when(basketRepo.getUserItems(any(UserId.class))).thenReturn(new ArrayList<BasketItem>(Arrays.asList(expectedItems)));
        var result = shoppingBasketService.basketFor(userId);
        assertEquals(expectedItems[0].dateAdded(), result.createdAt());
    }

    @Test void
    return_a_basket_with_correct_total_amount(){
        var productId = new ProductId(1);
        shoppingBasketService.basketFor(userId);
        when(basketRepo.getUserItems(any(UserId.class))).thenReturn(new ArrayList<BasketItem>(Arrays.asList(expectedItems)));
        verify(productRepository).get(productId);
    }
}
