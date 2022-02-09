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
    public Basket getByUserId(User user) {
        return baskets.findBasket(user);
    }

    @Override
    public Basket createBasket(User user) {
        return baskets.add(user);
    }

    @Override
    public void addItem(Basket basket, Product product, int quantity) {
        throw new UnsupportedOperationException();
    }
}
