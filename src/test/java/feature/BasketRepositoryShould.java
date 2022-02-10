package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketRepositoryShould {


    private UserId userId;
    private BasketRepository basketRepo;
    private Baskets baskets;

    @BeforeEach
    void setUp() {
        this.userId = new UserId(1);
        this.baskets = mock(Baskets.class);
        this.basketRepo = new BasketRepository(baskets);
    }

    @Test void
    returns_true_if_basket_exists(){
        basketRepo.getByUserId(userId);
        verify(baskets).findBasket(any(UserId.class));
    }

    @Test void
    creates_a_basket() {
        basketRepo.createBasket(userId);
        verify(baskets).create(any(UserId.class));
    }

    @Test void
    adds_item(){
        basketRepo.addUserItem(new UserId(1), new ProductId(1), 3, "");
        var result = basketRepo.getUserItems(new UserId(1));
        assertEquals(1, result.size());
    }

    @Test void
    add_item_when_list_exists() {
        basketRepo.addUserItem(new UserId(1), new ProductId(1), 3, "");
        basketRepo.addUserItem(new UserId(1), new ProductId(2), 1, "");
        var result = basketRepo.getUserItems(new UserId(1));
        assertEquals(2, result.size());
    }
}
