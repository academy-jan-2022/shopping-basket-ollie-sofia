package feature.Repositories;

import feature.Domain.Money;
import feature.Domain.Product;
import feature.Domain.ProductId;
import feature.Repositories.Interfaces.ProductRepository;

public class ProductRepositoryInMem implements ProductRepository {

    @Override
    public Product get(ProductId productId) {
       if(productId.id() == 10002 ) {
           return new Product(10002, "The Hobbit", new Money(5));
       } else {
           return new Product(20110, "Breaking Bad", new Money(7));
       }
    }
}
