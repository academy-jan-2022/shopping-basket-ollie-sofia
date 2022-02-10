package feature;

import java.util.List;

public class Baskets {

    private final List<Basket> baskets;

    public Baskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public Basket findBasket(UserId userId) {
        return baskets
                .stream()
                .filter(basket -> userId.id() == basket.getUserId())
                .findFirst()
                .orElse(null);
    }

    public Basket create(UserId userId) {
        Basket newBasket = new Basket(userId, "");
        baskets.add(newBasket);
        return newBasket;
    }

    public void addItem(Basket basket, Item item) {
        var basketIndex = baskets.indexOf(basket);

        if (basketIndex >= 0){
            var existingBasket = baskets.get(basketIndex);
            existingBasket.items.add(item);
        }
    }
}
