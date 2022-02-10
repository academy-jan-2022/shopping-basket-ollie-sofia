package feature;

public class ShoppingBasketService {

    private final IBasketRepository basketRepo;

    public ShoppingBasketService(IBasketRepository basketRepo) {
        this.basketRepo = basketRepo;
    }

    public void addItem(User user, Product product, int quantity) {
        var newItem = new Item(product, quantity);
        var userBasket = basketRepo.getByUserId(user);

        if (userBasket == null) {
            userBasket = basketRepo.createBasket(user);
        }

        basketRepo.addItem(userBasket, newItem);

    }

    public Basket basketFor(User user) {
        return new Basket(user);
    }
}
