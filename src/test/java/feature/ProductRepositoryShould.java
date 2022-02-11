package feature;

import feature.Domain.ProductId;
import feature.Repositories.ProductRepositoryInMem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryShould {

    @Test
    void
    return_expected_product() {
        var productRepo = new ProductRepositoryInMem();
        var result = productRepo.get(new ProductId(1));
        assertEquals(1, result);
    }
}
