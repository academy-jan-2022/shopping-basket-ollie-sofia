package feature;

public interface IBasketRepository {
    void add(User userId, Product productId, int quantity);
    Basket getByUserId(User user);
    Basket createBasket(User user);
    void addItem(Basket basket, Item item);
}
