package feature;

public class BasketRepository implements OrderRepository {

    private final Orders orders;

    public BasketRepository(Orders orders) {
        this.orders = orders;
    }

    public void add(BasketItem basketItem) {
        orders.add(basketItem);
    }
}
