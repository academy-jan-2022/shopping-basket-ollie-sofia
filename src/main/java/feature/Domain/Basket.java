package feature.Domain;

import java.util.List;

public record Basket(List<BasketEntry> entries, Money total, String createdAt) {
}
