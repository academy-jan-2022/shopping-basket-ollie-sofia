package feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(user, basket.user) && Objects.equals(items, basket.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, items);
    }
}
