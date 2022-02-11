package feature.Domain;

import feature.Domain.BasketEntry;

import java.util.List;

public record Basket(List<BasketEntry> entries, int total, String createdAt) {
}
