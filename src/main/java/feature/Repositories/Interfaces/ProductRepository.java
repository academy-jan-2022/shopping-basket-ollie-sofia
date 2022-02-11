package feature.Repositories.Interfaces;

import feature.Domain.Product;
import feature.Domain.ProductId;

public interface ProductRepository {
    Product get(ProductId productId);
}
