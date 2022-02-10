package feature;

import java.util.Date;
import java.util.List;

public record Basket(List<BasketEntry> entries, int total, Date createdAt) {
}
