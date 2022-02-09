package feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketsShould {

    @Test
    void
    add_an_item_to_the_list() {
        Baskets baskets = new Baskets();
        var basketItem = new BasketItem(1,1,2);
        baskets.add(basketItem);
        var result = baskets.getAll();
        assertEquals(result.size(), 1);
        assertEquals(basketItem, result.get(0));
    }

}
