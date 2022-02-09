package feature;

public class ShoppingBasketService {

    private final IBasketRepository basketRepo;

    public ShoppingBasketService(IBasketRepository basketRepo) {
        this.basketRepo = basketRepo;
    }

    public void addItem(User user, Product product, int quantity) {
        var userBasket = basketRepo.getByUserId(user);

        if(userBasket == null) {
            userBasket = basketRepo.createBasket(user);
        }

        basketRepo.addItem(userBasket, product, quantity);

    }

    public Basket basketFor(int i) {
        throw new UnsupportedOperationException();
    }
}
