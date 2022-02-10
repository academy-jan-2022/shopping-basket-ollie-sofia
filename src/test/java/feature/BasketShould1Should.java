package feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketShould1Should {

    @Test
    void
    print_header_with_correct_date() {
        var createdDate = "01/01/2020";
        Basket1 basket1 = new Basket1(new UserId(1), createdDate);
        var result = basket1.checkContent();
        var expected = "- Basket Created on " + createdDate + "\n";
        assertEquals(result, expected);
    }
}
