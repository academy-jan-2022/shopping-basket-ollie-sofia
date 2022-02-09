package feature;

import java.util.ArrayList;
import java.util.List;

public class Baskets {

    private final List<Basket> baskets;

    public Baskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public boolean exists(User user) {
        for (Basket basket : baskets) {
            if (user.equals(basket.user()))
                return true;
        }

        return false;
    }

    public Basket add(User user) {
        throw new UnsupportedOperationException();
    }
}
