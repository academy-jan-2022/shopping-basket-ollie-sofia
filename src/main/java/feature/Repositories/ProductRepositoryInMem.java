package feature.Repositories;

import feature.Domain.Product;
import feature.Domain.ProductId;
import feature.Repositories.Interfaces.ProductRepository;

public class ProductRepositoryInMem implements ProductRepository {
    @Override
    public Product get(ProductId productId) {
        return null;
    }
}
