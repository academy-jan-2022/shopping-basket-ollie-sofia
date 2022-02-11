package feature.Services;

import feature.Domain.Basket;
import feature.Domain.BasketEntry;
import feature.Domain.ProductId;
import feature.Domain.UserId;
import feature.Infrastructure.Providers.DateProvider;
import feature.Repositories.Interfaces.BasketRepository;
import feature.Repositories.Interfaces.ProductRepository;
import feature.Repositories.ProductRepositoryInMem;

import java.util.ArrayList;

public class ShoppingBasketService {

    private final BasketRepository basketRepo;
    private final ProductRepository productRepository;
    private DateProvider dateProvider;

    public ShoppingBasketService(BasketRepository basketRepo, ProductRepository productRepository, DateProvider dateProvider) {
        this.basketRepo = basketRepo;
        this.productRepository = productRepository;
        this.dateProvider = dateProvider;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {
        var date = dateProvider.Today();
        basketRepo.addUserItem(userId, productId, quantity, date);
    }

    public Basket basketFor(UserId userId) {
        var items = basketRepo.getUserItems(userId);

        if(items == null || items.size() == 0)
            return null;

        var basketEntries =  new ArrayList<BasketEntry>();

        for (var item : items){
            var product = productRepository.get(item.productId());
            var entry = new BasketEntry(item.productId(), item.quantity());
            basketEntries.add(entry);
        }

        var basket = new Basket(basketEntries, 0, items.get(0).dateAdded());

        return basket;
    }
}
