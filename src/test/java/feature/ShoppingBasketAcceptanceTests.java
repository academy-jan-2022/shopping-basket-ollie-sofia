package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketAcceptanceTests {
    private ShoppingBasketService shoppingBasketService;
    private User user;

//    - Creation date (of the shopping basket)
//      - 2 x The Hobbit   // 2 x 5.00 = £10.00
//      - 5 x Breaking Bad // 5 x 7.00 = £35.00
//      - Total: £45.00

    @BeforeEach
    void setUp(){
        this.shoppingBasketService = new ShoppingBasketService(new BasketRepository());
        this.user = new User(1);
    }

    @Test
    void E2E(){
        shoppingBasketService.addItem(user, new Product(1), 2);
        shoppingBasketService.addItem(user, new Product(2), 5);
        var basket = shoppingBasketService.basketFor(1);
        var result = basket.checkContent();
        var expected = "- Basket Created on 01/01/2020\n"
                + "- 2 x The Hobbit // 2 x 5.00 = £10.00\n"
                + "- 5 x Breaking Bad // 5 x 7.00 = £35.00"
                + "- Total: £45.00";

        assertEquals(expected, result);
    }
}
