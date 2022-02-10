package feature;

import java.util.ArrayList;
import java.util.Date;

public class ShoppingBasketService {

    private final IBasketRepository basketRepo;
    private DateProvider dateProvider;

    public ShoppingBasketService(IBasketRepository basketRepo, DateProvider dateProvider) {
        this.basketRepo = basketRepo;
        this.dateProvider = dateProvider;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {
        var date = dateProvider.Today();
        basketRepo.addUserItem(userId, productId, quantity, date);
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
