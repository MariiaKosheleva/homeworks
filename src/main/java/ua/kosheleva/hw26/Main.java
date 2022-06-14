package ua.kosheleva.hw26;

import com.mongodb.client.MongoDatabase;
import ua.kosheleva.hw26.dao.CustomerDao;
import ua.kosheleva.hw26.dao.OrderDao;
import ua.kosheleva.hw26.dao.ProductDao;
import ua.kosheleva.hw26.service.CustomerService;
import ua.kosheleva.hw26.service.OrderService;
import ua.kosheleva.hw26.service.ProductService;
import ua.kosheleva.hw26.utils.MongoDBUtil;

public class Main {
    private static final MongoDatabase dataBase = MongoDBUtil.connect("hw26");

    public static void main(String[] args) {

        ProductDao productDao = new ProductDao(dataBase);
        OrderDao orderDao = new OrderDao(dataBase);
        CustomerDao customerDao = new CustomerDao(dataBase);

        ProductService productService = new ProductService(productDao);
        CustomerService customerService = new CustomerService(customerDao);
        OrderService orderService = new OrderService(productDao, orderDao, customerDao);

        orderService.runOrderService();
        productService.runProductService();
        customerService.runCustomerService();
    }

}
