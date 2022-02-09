package feature;

public class BasketRepository implements IBasketRepository {
    public void add(User userId, Product productId, int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean exists(User user) {
        return true;
    }
}
