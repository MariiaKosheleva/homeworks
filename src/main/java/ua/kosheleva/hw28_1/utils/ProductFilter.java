package ua.kosheleva.hw28_1.utils;

import ua.kosheleva.hw28_1.model.NotifiableProduct;

import java.util.List;

public class ProductFilter {
    public int filterNotifiableProductsAndSendNotifications(ProductRepository repository) {
        int notifications = 0;
        List<NotifiableProduct> products = repository.getAll().stream()
                .filter(it -> it.getClass().getSimpleName().equals("NotifiableProduct")).map(it -> (NotifiableProduct) it).toList();
        for (NotifiableProduct ignored : products) {
            notifications++;
        }
        return notifications;
    }
}
