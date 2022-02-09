package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketRepositoryShould {


    private User user;
    private BasketRepository basketRepo;
    private Baskets baskets;

    @BeforeEach
    void setUp() {
        this.user = new User(1);
        this.baskets = mock(Baskets.class);
        this.basketRepo = new BasketRepository();
    }

    @Test void
    returns_true_if_basket_exists(){
        basketRepo.exists(user);
        verify(baskets).exists(any(User.class));
    }
}
