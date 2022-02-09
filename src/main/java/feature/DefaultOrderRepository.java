package feature;

public class DefaultOrderRepository implements OrderRepository {

    private final Orders orders;

    public DefaultOrderRepository(Orders orders) {
        this.orders = orders;
    }

    public void add(int userId, int productId, int quantity) {
        orders.add(userId, productId, quantity);
    }
}
