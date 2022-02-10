package feature;

import java.util.Date;
import java.util.List;

public record Basket(List<ProductQuantity> items, int total, Date createdAt) {
}
