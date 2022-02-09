package feature;

public class ShoppingBasketService {

    private final OrderRepository orderRepository;

    public ShoppingBasketService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addItem(int userId, int productId, int quantity) {
        orderRepository.add(userId, productId, quantity);
    }

    public Basket basketFor(int i) {
        throw new UnsupportedOperationException();
    }
}
