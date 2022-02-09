package feature;

public interface OrderRepository {
    void add(int userId, int productId, int quantity);
}
