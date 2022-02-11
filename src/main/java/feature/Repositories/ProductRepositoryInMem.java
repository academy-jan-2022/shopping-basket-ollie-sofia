package feature.Repositories;

import feature.Domain.Money;
import feature.Domain.Product;
import feature.Domain.ProductId;
import feature.Repositories.Interfaces.ProductRepository;

public class ProductRepositoryInMem implements ProductRepository {



    @Override
    public Product get(ProductId productId) {
        return new Product(10002, "The Hobbit", new Money(5));
    }
}
