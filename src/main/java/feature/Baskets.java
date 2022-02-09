package feature;

import java.util.ArrayList;
import java.util.List;

public class Baskets {

    List<Basket> baskets = new ArrayList<>();

    public boolean exists(User user) {
        for (Basket basket : baskets) {
            if (user.equals(basket.user()))
                return true;
        }
        return false;
    }
}
