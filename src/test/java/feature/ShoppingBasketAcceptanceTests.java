package feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketAcceptanceTests {

//    - Creation date (of the shopping basket)
//      - 2 x The Hobbit   // 2 x 5.00 = £10.00
//      - 5 x Breaking Bad // 5 x 7.00 = £35.00
//      - Total: £45.00
    @Test
    void E2E(){
        var shoppingBasket = new ShoppingBasketService();
        shoppingBasket.addItem(1, 1, 2);
        shoppingBasket.addItem(1, 2, 5);
        var basket = shoppingBasket.basketFor(1);
        var result = basket.showOrder();
        var expected = "- Basket Created on 01/01/2020\n"
                + "- 2 x The Hobbit // 2 x 5.00 = £10.00\n"
                + "- 5 x Breaking Bad // 5 x 7.00 = £35.00"
                + "- Total: £45.00";

        assertEquals(expected, result);
    }
}
