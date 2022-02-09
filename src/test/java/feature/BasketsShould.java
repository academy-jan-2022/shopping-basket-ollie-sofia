package feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketsShould {

    private Baskets baskets;
    private User user;

    @BeforeEach
    void setUp() {
        this.baskets = new Baskets();
        this.user = new User(1);
    }

    @Test
    void return_false_when_calling_exists_when_no_baskets(){
        var expected = false;
        var result = baskets.exists(user);
        assertEquals(expected, result);
    }

    @Test
    void return_true_when_existing_baskets(){
        var expected = true;
        var result = baskets.exists(user);
        assertEquals(expected, result);
    }
}
