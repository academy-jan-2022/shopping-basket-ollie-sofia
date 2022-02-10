package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketAcceptanceTestsShould {
    private ShoppingBasketService shoppingBasketService;
    private UserId userId;

//    - Creation date (of the shopping basket)
//      - 2 x The Hobbit   // 2 x 5.00 = £10.00
//      - 5 x Breaking Bad // 5 x 7.00 = £35.00
//      - Total: £45.00

    @BeforeEach
    void setUp(){
        this.shoppingBasketService = new ShoppingBasketService(new BasketRepository(new Baskets(new ArrayList<>())), new SimpleDateProvider());
        this.userId = new UserId(1);
    }

    @Test
    void E2E(){
        shoppingBasketService.addItem(userId, new ProductId(1), 2);
        shoppingBasketService.addItem(userId, new ProductId(2), 5);
        var basket = shoppingBasketService.basketFor(userId);
//        var result = basket.checkContent();
        var expected = "- Basket Created on 01/01/2020\n"
                + "- 2 x The Hobbit // 2 x 5.00 = £10.00\n"
                + "- 5 x Breaking Bad // 5 x 7.00 = £35.00"
                + "- Total: £45.00";

//        assertEquals(expected, result);
    }
}
