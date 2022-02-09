package feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersShould {

    @Test
    void
    add_an_item_to_the_list() {
        Orders orders = new Orders();
        orders.add(new BasketItem(1,1,2));
        var result = orders.getAll();
        assertEquals(result.size(), 1);
    }
}
