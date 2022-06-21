package ua.kosheleva.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.kosheleva.hw26.model.Order;

import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class OrderDao extends AbstractDao<Order> {
    private static final String COLLECTION_NAME = "orders";

    public OrderDao(MongoDatabase database) {
        super(database, COLLECTION_NAME);
    }

    public List<Order> findManyByProductsCount(int count) {
        String query = "this.products.length > " + count;
        return super.findAllByFilter(Order.class, and(exists("products"), where(query)));
    }

    public void deleteCertainOrder(String id) {
        final Document filter = new Document();
        filter.append("id", id);

        collection.deleteOne(filter);
    }

    public List<Order> findAll() {
        return super.findAll(Order.class);
    }

    public List<Order> findOrdersForCertainCustomerByName(String name, CustomerDao customerDao) {
        String customerIdFromDB = customerDao.findManyByName(name).get(0).getId();
        return super.findAllByFilter(Order.class, eq("customerId", customerIdFromDB));
    }

    public void updateCustomer(String orderId, String customerId) {
        final Document filter = new Document();
        filter.append("id", orderId);

        final Document update = new Document();
        update.append("customerId", customerId);

        final Document document = new Document();
        document.append("$set", update);

        collection.updateOne(filter, document);
    }

    public void updateProducts(String productId, List<String> products) {
        final Document filter = new Document();
        filter.append("id", productId);

        final Document update = new Document();
        update.append("products", products);

        final Document document = new Document();
        document.append("$set", update);

        collection.updateOne(filter, document);
    }
}
