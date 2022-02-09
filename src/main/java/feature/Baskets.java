package feature;

import java.util.List;

public class Baskets {

    private final List<Basket> baskets;

    public Baskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public Basket findBasket(User user) {
        return baskets
                .stream()
                .filter(basket -> user.equals(basket.user()))
                .findFirst()
                .orElse(null);
//        for (Basket basket : baskets) {
//            if (user.equals(basket.user()))
//                return true;
//        }
//
//        return false;
    }

    public Basket add(User user) {
        Basket newBasket = new Basket(user);
        baskets.add(newBasket);
        return newBasket;
    }
}
