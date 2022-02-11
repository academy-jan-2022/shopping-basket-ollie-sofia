package feature;

import feature.Domain.UserId;

import java.util.List;

public class Baskets {

    private final List<Basket1> basket1s;

    public Baskets(List<Basket1> basket1s) {
        this.basket1s = basket1s;
    }

    public Basket1 findBasket(UserId userId) {
        return basket1s
                .stream()
                .filter(basket -> userId.id() == basket.getUserId())
                .findFirst()
                .orElse(null);
    }

    public Basket1 create(UserId userId) {
        Basket1 newBasket1 = new Basket1(userId, "");
        basket1s.add(newBasket1);
        return newBasket1;
    }

    public void addItem(Basket1 basket1, Item item) {
        var basketIndex = basket1s.indexOf(basket1);

        if (basketIndex >= 0){
            var existingBasket = basket1s.get(basketIndex);
            existingBasket.items.add(item);
        }
    }
}
