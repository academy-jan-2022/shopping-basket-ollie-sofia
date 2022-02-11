package feature.Domain;

import feature.Domain.ProductId;

public record BasketEntry(ProductId productId, Integer quantity) {
}
