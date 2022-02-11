package feature.Repositories.Interfaces;

import feature.*;
import feature.Domain.BasketItem;
import feature.Domain.ProductId;
import feature.Domain.UserId;

import java.util.ArrayList;

public interface BasketRepository {
    void add(UserId userId, ProductId productId, int quantity);
    Basket1 getByUserId(UserId userId);
    Basket1 createBasket(UserId userId);
    void addItem(Basket1 basket1, Item item);

    void addUserItem(UserId userId, ProductId productId, int quantity, String date);

    ArrayList<BasketItem> getUserItems(UserId userId);
}
