package feature;

import java.util.ArrayList;

public interface IBasketRepository {
    void add(UserId userId, ProductId productId, int quantity);
    Basket1 getByUserId(UserId userId);
    Basket1 createBasket(UserId userId);
    void addItem(Basket1 basket1, Item item);

    void addUserItem(UserId userId, ProductId productId, int quantity);

    ArrayList<ProductQuantity> getUserItems(UserId userId);
}
