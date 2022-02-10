package feature;

public class ShoppingBasketService {

    private final IBasketRepository basketRepo;

    public ShoppingBasketService(IBasketRepository basketRepo) {
        this.basketRepo = basketRepo;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {
        basketRepo.addUserItem(userId, productId, quantity);
//        var newItem = new Item(product, quantity);
//        var userBasket = basketRepo.getByUserId(userId);
//
//        if (userBasket == null) {
//            userBasket = basketRepo.createBasket(userId);
//        }
//
//        basketRepo.addItem(userBasket, newItem);
    }

    public Basket basketFor(UserId userId) {

        return basketRepo.getByUserId(userId);
    }
}
