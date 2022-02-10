package feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {

    private final UserId userId;
    private final String dateCreated;
    public List<Item> items = new ArrayList<>();

    public Basket(UserId userId, String dateCreated) {
        this.userId = userId;
        this.dateCreated = dateCreated;
    }

    public String checkContent() {
        return "- Basket Created on " + dateCreated + "\n";
    }

    public int getUserId(){
        return userId.id();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(userId, basket.userId) && Objects.equals(items, basket.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, items);
    }
}
