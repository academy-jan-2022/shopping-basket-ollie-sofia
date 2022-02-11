package feature.Repositories;

import feature.Domain.Money;
import feature.Domain.Product;
import feature.Domain.ProductId;
import feature.Repositories.Interfaces.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProductRepositoryInMem implements ProductRepository {

    List<ProductDAL> productsDAL = new ArrayList<ProductDAL>(Arrays.asList(
            new ProductDAL(10002, "The Hobbit", new Money(5)),
            new ProductDAL(20110, "Breaking Bad", new Money(7))
    ));

    @Override
    public Product get(ProductId productId) {
       var product = productsDAL.stream().filter(productDAL -> productDAL.productId == productId.id()).findFirst().map(productDAL -> new Product(productDAL.productId, productDAL.title, productDAL.amount)).orElse(null);
       return product;
    }

    private record ProductDAL(Integer productId, String title, Money amount) {}
}
