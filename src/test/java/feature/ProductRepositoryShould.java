package feature;

import feature.Domain.Money;
import feature.Domain.Product;
import feature.Domain.ProductId;
import feature.Repositories.ProductRepositoryInMem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryShould {

    @Test
    void
    return_expected_product_hobbit() {
        var expectedProduct = new Product(10002, "The Hobbit", new Money(5));
        var productRepo = new ProductRepositoryInMem();
        var result = productRepo.get(new ProductId(10002));
        assertEquals(expectedProduct, result);
    }

    @Test
    void
    return_expected_product_breaking_bad() {
        var expectedProduct = new Product(20110, "Breaking Bad", new Money(7));
        var productRepo = new ProductRepositoryInMem();
        var result = productRepo.get(new ProductId(20110));
        assertEquals(expectedProduct, result);
    }
}
