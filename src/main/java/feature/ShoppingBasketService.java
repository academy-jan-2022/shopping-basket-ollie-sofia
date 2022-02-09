package feature;

public class ShoppingBasketService {

    private final BasketRepository basketRepository;

    public ShoppingBasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void addItem(BasketItem basketItem) {
        basketRepository.add(basketItem);
    }

    public Basket basketFor(int i) {
        throw new UnsupportedOperationException();
    }
}
