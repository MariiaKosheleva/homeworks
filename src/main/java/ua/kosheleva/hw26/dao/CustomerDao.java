package ua.kosheleva.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.kosheleva.hw26.model.Customer;

import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class CustomerDao extends AbstractDao<Customer> {
    private static final String COLLECTION_NAME = "customers";

    public CustomerDao(MongoDatabase database) {
        super(database, COLLECTION_NAME);
    }


    public List<Customer> findManyByName(String name) {
        return super.findAllByFilter(Customer.class, or(eq("firstName", name), eq("lastName", name)));
    }

    public List<Customer> findAll() {
        return super.findAll(Customer.class);
    }

    public void updateStatus(String newStatus) {
        String status = "this.age < + 18";

        final Document update = new Document();
        update.append("status", newStatus);

        final Document document = new Document();
        document.append("$set", update);

        collection.updateMany(where(status), document);
    }

    public void updateOrders(String orderId, String customerId) {
        final Document filter = new Document();
        filter.append("id", customerId);

        final Document update = new Document();
        update.append("orderId", orderId);

        final Document document = new Document();
        document.append("$set", update);

        collection.updateOne(filter, document);
    }
}
