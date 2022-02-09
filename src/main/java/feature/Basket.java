package feature;

public class Basket {
    public Integer userId;

    public Basket(Integer userId) {
        this.userId = userId;
    }

    public String showOrder() {
        throw new UnsupportedOperationException();
    }
}
