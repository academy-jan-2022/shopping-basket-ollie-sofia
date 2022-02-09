package feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orders {

    private List<BasketItem> baskets = new ArrayList(){};

    public void add(BasketItem basketItem) {

        baskets.add(basketItem);
    }

    public List<BasketItem> getAll() {
        return Collections.unmodifiableList(baskets);
    }
}
