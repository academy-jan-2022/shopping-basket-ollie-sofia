package feature;

public class ShoppingBasketService {

    private final IBasketRepository basketRepo;

    public ShoppingBasketService(IBasketRepository basketRepo) {
        this.basketRepo = basketRepo;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {
        basketRepo.addUserItem(userId, productId, quantity);
    }

    public Basket basketFor(UserId userId) {
        basketRepo.getUserItems(userId);
        return null;
    }
}
