package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class ShoppingBasketServiceShould {


    @Test
    void
    add_an_item_to_the_basket() {
        var shoppingBasketService = new ShoppingBasketService();
        shoppingBasketService.addItem(new User(1), new Product(1), 2);
        //verify().add(1, 1, 2);
    }
}
