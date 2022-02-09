package feature;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final User user;
    public List<Item> items = new ArrayList<>();

    public Basket(User user) {
        this.user = user;
    }

    public String checkContent() {
        throw new UnsupportedOperationException();
    }

    public int getUserId(){
        return user.id();
    }
}
