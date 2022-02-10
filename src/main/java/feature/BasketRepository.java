package feature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class BasketRepository implements IBasketRepository {

    private final Baskets baskets;
    private final Hashtable<UserId, List<ProductQuantityDAL>> basketItems;


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
        var productQuantity = new ProductQuantityDAL(productId, 4);

        if (!basketItems.containsKey(userId)){
            var userProductList =  new ArrayList<ProductQuantityDAL>();
            basketItems.put(userId, userProductList);
        }

        basketItems.get(userId).add(productQuantity);

    }

    @Override
    public ArrayList<feature.ProductQuantity> getUserItems(UserId userId) {

        var items = basketItems.get(userId);
        var result = new ArrayList<ProductQuantity>();
        for(var item : items) {
            var product = new ProductQuantity(item.productId, item.quantity);
            result.add(product);
        }
        return result;
    }

    private record ProductQuantityDAL(ProductId productId, Integer quantity){

    }
}
