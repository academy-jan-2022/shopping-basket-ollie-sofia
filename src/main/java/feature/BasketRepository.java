package feature;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class BasketRepository implements IBasketRepository {

    private final Baskets baskets;
    private final Hashtable<UserId, List<BasketItemDAL>> userBaskets;

    public BasketRepository(Baskets baskets) {
        this.baskets = baskets;
        this.userBaskets = new Hashtable<>();
    }

    public void add(UserId userId, ProductId productId, int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Basket1 getByUserId(UserId userId) {
        return baskets.findBasket(userId);
    }

    @Override
    public Basket1 createBasket(UserId userId) {
        return baskets.create(userId);
    }

    @Override
    public void addItem(Basket1 basket1, Item item) {
        baskets.addItem(basket1, item);
    }

    @Override
    public void addUserItem(UserId userId, ProductId productId, int quantity, String dateAdded) {
        var productQuantity = new BasketItemDAL(productId, quantity, dateAdded);

        if (!userBaskets.containsKey(userId)){
            var userProductList =  new ArrayList<BasketItemDAL>();
            userBaskets.put(userId, userProductList);
        }

        userBaskets.get(userId).add(productQuantity);

    }

    @Override
    public ArrayList<BasketItem> getUserItems(UserId userId) {

        var items = userBaskets.get(userId);
        var result = new ArrayList<BasketItem>();
        for(var item : items) {
            var product = new BasketItem(item.productId(), item.quantity(), item.dateAdded());
            result.add(product);
        }
        return result;
    }

    private record BasketItemDAL(ProductId productId, Integer quantity, String dateAdded){

    }
}
