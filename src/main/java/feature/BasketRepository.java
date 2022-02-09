package feature;

public class BasketRepository implements IBasketRepository {

    private final Baskets baskets;

    public BasketRepository() {
        this.baskets = new Baskets();
    }

    public void add(User userId, Product productId, int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean exists(User user) {
        return baskets.exists(user);
    }
}
