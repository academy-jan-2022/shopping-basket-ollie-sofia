package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DefaultBasketRepositoryShould {

    @Mock
    Baskets baskets;

    @BeforeEach
    void setUp(){
        this.baskets = mock(Baskets.class);
    }

    @Test
    void invoke_create_method_on_order_memoryDb(){
        BasketRepository orderRepo = new DefaultBasketRepository(baskets);
        orderRepo.add(new BasketItem(1, 1,2));

        verify(baskets).add(new BasketItem(1, 1,2));
    }
}
