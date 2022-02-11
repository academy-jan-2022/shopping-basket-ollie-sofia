package feature.Domain;

import feature.Domain.ProductId;

public record BasketItem(ProductId productId, Integer quantity, String dateAdded) {
}
