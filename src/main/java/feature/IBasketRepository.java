package feature;

public interface IBasketRepository {
    void add(User userId, Product productId, int quantity);
    boolean exists(User user);
    Basket createBasket(User user);
    void addItem(User user);
}
