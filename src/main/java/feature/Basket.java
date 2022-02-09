package feature;

public record Basket(User user) {

    public String checkContent() {
        throw new UnsupportedOperationException();
    }
}
