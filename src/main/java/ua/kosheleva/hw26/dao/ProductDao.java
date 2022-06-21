package ua.kosheleva.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.kosheleva.hw26.model.Product;

import java.util.List;

public class ProductDao extends AbstractDao<Product> {
    private static final String COLLECTION_NAME = "products";

    public ProductDao(MongoDatabase database) {
        super(database, COLLECTION_NAME);
    }

    public List<Product> findAll() {
        return super.findAll(Product.class);
    }

    public void updatePrice(String productName, Float price) {
        final Document filter = new Document();
        filter.append("name", productName);

        final Document update = new Document();
        update.append("price", price);

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateOne(filter, doc);
    }

    public void updateOrders(String orderId, String productId) {
        final Document filter = new Document();
        filter.append("id", productId);

        final Document update = new Document();
        update.append("orderId", orderId);

        final Document document = new Document();
        document.append("$set", update);

        collection.updateOne(filter, document);
    }

}
