package feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketShould {
    @Test
    void
    show_date_and_total_when_empty(){
        var basket = new Basket(1, "01/01/2020");
        var result = basket.checkContent();
        var expected = "- Basket Created on 01/01/2020\n"
                + "- Total: £0";

        assertEquals(expected, result);
    }
}
