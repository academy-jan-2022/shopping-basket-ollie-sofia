package feature;

import java.util.ArrayList;
import java.util.List;

public interface IBasketRepository {
    void add(UserId userId, ProductId productId, int quantity);
    Basket getByUserId(UserId userId);
    Basket createBasket(UserId userId);
    void addItem(Basket basket, Item item);

    void addUserItem(UserId userId, ProductId productId, int quantity);

    ArrayList<ProductQuantity> getUserItems(UserId userId);
}
