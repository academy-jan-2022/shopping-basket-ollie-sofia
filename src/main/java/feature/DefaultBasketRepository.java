package feature;

public class DefaultBasketRepository implements BasketRepository {

    private final Baskets baskets;

    public DefaultBasketRepository(Baskets baskets) {
        this.baskets = baskets;
    }

    public void add(BasketItem basketItem) {
        baskets.add(basketItem);
    }
}
