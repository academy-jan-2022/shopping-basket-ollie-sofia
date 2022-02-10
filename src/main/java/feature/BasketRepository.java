package feature;
import java.util.ArrayList;
import java.util.Hashtable;

public class BasketRepository implements IBasketRepository {



    private final Baskets baskets;
    private final Hashtable<Integer, BasketRepository.ProductQuantity> basketItems;


    public BasketRepository(Baskets baskets) {
        this.baskets = baskets;
        this.basketItems = new Hashtable<>();
    }

    public void add(UserId userId, ProductId productId, int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Basket getByUserId(UserId userId) {
        return baskets.findBasket(userId);
    }

    @Override
    public Basket createBasket(UserId userId) {
        return baskets.create(userId);
    }

    @Override
    public void addItem(Basket basket, Item item) {
        baskets.addItem(basket, item);
    }

    @Override
    public void addUserItem(UserId userId, ProductId productId, int quantity) {
    }

    @Override
    public ArrayList<feature.ProductQuantity> getUserItems(UserId userId) {
        return new ArrayList<feature.ProductQuantity>();
    }

    private record ProductQuantity(Integer productId, Integer quantity){

    }
}
