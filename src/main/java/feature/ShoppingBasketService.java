package feature;

public class ShoppingBasketService {

    private final Order order;

    public ShoppingBasketService(Order order) {
        this.order = order;
    }

    public void addItem(int i, int i1, int i2) {
        order.add(i,i1, i2);
    }

    public Basket basketFor(int i) {
        throw new UnsupportedOperationException();
    }
}
