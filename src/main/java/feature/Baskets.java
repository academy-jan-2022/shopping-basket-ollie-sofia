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
                .filter(basket -> user.id() == basket.getUserId())
                .findFirst()
                .orElse(null);
    }

    public Basket create(User user) {
        Basket newBasket = new Basket(user);
        baskets.add(newBasket);
        return newBasket;
    }

    public void addItem(Basket basket, Item item) {
        throw new UnsupportedOperationException();
    }
}
