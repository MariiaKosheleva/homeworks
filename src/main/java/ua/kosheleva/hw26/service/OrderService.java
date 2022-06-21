package ua.kosheleva.hw26.service;

import ua.kosheleva.hw26.dao.CustomerDao;
import ua.kosheleva.hw26.dao.OrderDao;
import ua.kosheleva.hw26.dao.ProductDao;
import ua.kosheleva.hw26.model.Customer;
import ua.kosheleva.hw26.model.Order;
import ua.kosheleva.hw26.model.Product;

import java.util.Arrays;
import java.util.List;

public class OrderService {

    private final ProductDao productDao;
    private final OrderDao orderDao;
    private final CustomerDao customerDao;

    public OrderService(ProductDao productDao, OrderDao orderDao, CustomerDao customerDao) {
        this.productDao = productDao;
        this.orderDao = orderDao;
        this.customerDao = customerDao;
    }

    public void runOrderService() {
        System.out.println("=".repeat(220));
        System.out.println("createProducts");
        createProducts();
        System.out.println("=".repeat(220));
        System.out.println("createOrders");
        createOrders();
        System.out.println("=".repeat(220));
        System.out.println("createCustomers");
        createCustomers();
        System.out.println("=".repeat(220));
        System.out.println("bindProductOrder");
        bindProductOrder();
        System.out.println("=".repeat(220));
        System.out.println("bindOrderCustomer");
        bindOrderCustomer();
        System.out.println("=".repeat(220));
        System.out.println("printAllOrders");
        printAllOrders();
        System.out.println("=".repeat(220));
        System.out.println("printOrdersOfCertainCustomer");
        printOrdersOfCertainCustomer("Dan");
        System.out.println("=".repeat(220));
        System.out.println("deleteCertainOrder");
        deleteCertainOrder(0);
        System.out.println("=".repeat(220));
        System.out.println("printAllOrders");
        printAllOrders();
        System.out.println("=".repeat(220));
        System.out.println("findByProducts");
        findByProducts();
        System.out.println("=".repeat(220));
    }

    private void findByProducts() {
        orderDao.findManyByProductsCount(1).forEach(System.out::println);
    }

    private void deleteCertainOrder(Integer index) {
        List<Order> orders = orderDao.findAll();
        orderDao.deleteCertainOrder(orders.get(index).getId());
    }

    private void printOrdersOfCertainCustomer(String name) {
        orderDao.findOrdersForCertainCustomerByName(name, customerDao).forEach(System.out::println);
    }

    private void printAllOrders() {
        orderDao.findAll().forEach(System.out::println);
    }

    private void bindOrderCustomer() {
        List<Order> orders = orderDao.findAll();
        List<Customer> customers = customerDao.findAll();

        Order o1 = orders.get(0);
        Order o2 = orders.get(1);
        Order o3 = orders.get(2);
        Order o4 = orders.get(3);
        Order o5 = orders.get(4);
        Order o6 = orders.get(5);

        Customer customer1 = customers.get(0);
        Customer customer2 = customers.get(1);
        Customer customer3 = customers.get(2);
        Customer customer4 = customers.get(3);

        orderDao.updateCustomer(o1.getId(), customer1.getId());
        orderDao.updateCustomer(o2.getId(), customer2.getId());
        orderDao.updateCustomer(o3.getId(), customer2.getId());
        orderDao.updateCustomer(o4.getId(), customer3.getId());
        orderDao.updateCustomer(o5.getId(), customer4.getId());
        orderDao.updateCustomer(o6.getId(), customer4.getId());

        customerDao.updateOrders(o1.getId(), customer1.getId());
        customerDao.updateOrders(o2.getId(), customer2.getId());
        customerDao.updateOrders(o3.getId(), customer2.getId());
        customerDao.updateOrders(o4.getId(), customer3.getId());
        customerDao.updateOrders(o5.getId(), customer4.getId());
        customerDao.updateOrders(o6.getId(), customer4.getId());
    }

    private void bindProductOrder() {
        List<Product> products = productDao.findAll();
        List<Order> orders = orderDao.findAll();

        Product prod1 = products.get(0);
        Product prod2 = products.get(1);
        Product prod3 = products.get(2);
        Product prod4 = products.get(3);
        Product prod5 = products.get(4);

        Order o1 = orders.get(0);
        Order o2 = orders.get(1);
        Order o3 = orders.get(2);
        Order o4 = orders.get(3);
        Order o5 = orders.get(4);
        Order o6 = orders.get(5);

        productDao.updateOrders(o1.getId(), prod1.getId());
        productDao.updateOrders(o1.getId(), prod2.getId());
        productDao.updateOrders(o2.getId(), prod3.getId());
        productDao.updateOrders(o3.getId(), prod4.getId());
        productDao.updateOrders(o3.getId(), prod5.getId());
        productDao.updateOrders(o4.getId(), prod4.getId());
        productDao.updateOrders(o5.getId(), prod3.getId());
        productDao.updateOrders(o5.getId(), prod4.getId());
        productDao.updateOrders(o6.getId(), prod1.getId());

        orderDao.updateProducts(o1.getId(), Arrays.asList(prod1.getId(), prod2.getId()));
        orderDao.updateProducts(o2.getId(), List.of(prod3.getId()));
        orderDao.updateProducts(o3.getId(), Arrays.asList(prod4.getId(), prod5.getId()));
        orderDao.updateProducts(o4.getId(), List.of(prod4.getId()));
        orderDao.updateProducts(o5.getId(), Arrays.asList(prod3.getId(), prod4.getId()));
        orderDao.updateProducts(o6.getId(), List.of(prod1.getId()));
    }

    private void createCustomers() {
        final Customer customer1 = new Customer("Mike", "Oysho", 29, "new");
        final Customer customer2 = new Customer("Leo", "Jens", 9, "new");
        final Customer customer3 = new Customer("Dan", "Bail", 49, "new");
        final Customer customer4 = new Customer("Lola", "Patrils", 17, "new");
        customerDao.insertMany(Arrays.asList(customer1, customer2, customer3, customer4));
    }

    private void createOrders() {
        final Order order1 = new Order();
        final Order order2 = new Order();
        final Order order3 = new Order();
        final Order order4 = new Order();
        final Order order5 = new Order();
        final Order order6 = new Order();
        orderDao.insertMany(Arrays.asList(order1, order2, order3, order4, order5, order6));
    }

    private void createProducts() {
        final Product prod1 = new Product("tomato", 44.2f, 4);
        final Product prod2 = new Product("mushrooms", 34.7f, 8);
        final Product prod3 = new Product("cheese", 69.7f, 2);
        final Product prod4 = new Product("oil", 131.4f, 1);
        final Product prod5 = new Product("garlic", 17.2f, 1);
        productDao.insertMany(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
    }
}
