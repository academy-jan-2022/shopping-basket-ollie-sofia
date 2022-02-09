package feature;

public class BasketRepository implements IBasketRepository {

    private final Baskets baskets;

    public BasketRepository(Baskets baskets) {
        this.baskets = baskets;
    }

    public void add(User userId, Product productId, int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean exists(User user) {
        return baskets.exists(user);
    }

    @Override
    public Basket createBasket(User user) {
        throw new UnsupportedOperationException();
    }
}
