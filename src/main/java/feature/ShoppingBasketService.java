package feature;

public class ShoppingBasketService {

    private final Order order;

    public ShoppingBasketService(Order order) {
        this.order = order;
    }

    public void addItem(int userId, int productId, int quantity) {
        order.add(userId, productId, quantity);
    }

    public Basket basketFor(int i) {
        throw new UnsupportedOperationException();
    }
}
