package feature;

public class ShoppingBasketService {

    private final IBasketRepository basketRepo;

    public ShoppingBasketService(IBasketRepository basketRepo) {
        this.basketRepo = basketRepo;
    }

    public void addItem(User user, Product product, int quantity) {
        var userBasketExists = basketRepo.exists(user);
        if(!userBasketExists) {
            basketRepo.createBasket(user);
        }
    }

    public Basket basketFor(int i) {
        throw new UnsupportedOperationException();
    }
}
