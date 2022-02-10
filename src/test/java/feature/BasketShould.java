package feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketShould {

    @Test
    void
    print_header() {
        Basket basket = new Basket(new User(1));
        var result =basket.checkContent();
        var expected = "- Basket Created on 01/01/2020\n";
        assertEquals(result, expected);
    }
}
