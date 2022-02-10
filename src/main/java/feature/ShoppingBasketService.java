package feature;

import java.util.ArrayList;
import java.util.Date;

public class ShoppingBasketService {

    private final IBasketRepository basketRepo;

    public ShoppingBasketService(IBasketRepository basketRepo) {
        this.basketRepo = basketRepo;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {
        basketRepo.addUserItem(userId, productId, quantity);
    }

    public Basket basketFor(UserId userId) {
        var productQuantities = basketRepo.getUserItems(userId);
        var basketEntries =  new ArrayList<BasketEntry>();

        for (var productQuantity : productQuantities){
            var entry = new BasketEntry(productQuantity.productId(), productQuantity.quantity());
            basketEntries.add(entry);
        }

        var basket = new Basket(basketEntries, 0, new Date());

        return basket;
    }
}
