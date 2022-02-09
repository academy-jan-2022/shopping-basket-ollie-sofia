package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderRepositoryShould {

    @Mock Orders orders;

    @BeforeEach
    void setUp(){
        this.orders = mock(Orders.class);
    }

    @Test
    void invoke_create_method_on_order_memoryDb(){
        OrderRepository orderRepo = new BasketRepository(orders);
        orderRepo.add(new BasketItem(1, 1,2));

        verify(orders).add(new BasketItem(1, 1,2));
    }
}
