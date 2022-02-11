package feature.Domain;

public record BasketEntry(ProductId productId, Integer quantity, Money total) {
}
