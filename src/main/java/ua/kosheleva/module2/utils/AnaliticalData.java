package ua.kosheleva.module2.utils;

import ua.kosheleva.module2.models.CheckType;
import ua.kosheleva.module2.models.Invoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnaliticalData {
    public static final int AGE_LIMIT = 18;

    public int soldProductsByCategories(ArrayList<Invoice> invoices, String type) {
        return (int) invoices.stream()
                .map(Invoice::getProducts)
                .flatMap(products -> Arrays.stream(products)
                        .filter(product -> product.getClass().getSimpleName().equals(type)))
                .count();
    }

    public Invoice getCheckWithMinSum(ArrayList<Invoice> invoices) {
        return invoices.stream()
                .min(Comparator.comparing(Invoice::countCheckSum))
                .get();
    }

    public double countSumOfAllInvoices(ArrayList<Invoice> invoices) {
        return invoices.stream()
                .mapToDouble(Invoice::countCheckSum)
                .sum();
    }

    public int countChecksWithRetailType(ArrayList<Invoice> invoices) {
        return (int) invoices.stream()
                .filter(product -> product.getType() == CheckType.RETAIL)
                .count();
    }

    public List<Invoice> getChecksWithOneProductType(ArrayList<Invoice> invoices) {
        return invoices.stream()
                .filter(product -> Arrays.stream(product.getProducts())
                        .allMatch(x -> x.getClass().getSimpleName().equals("Telephone"))
                        || Arrays.stream(product.getProducts()).allMatch(x -> x.getClass().getSimpleName().equals("Television")))
                .collect(Collectors.toList());
    }

    public List<Invoice> getThreeFirstChecks(ArrayList<Invoice> invoices) {
        return invoices.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<Invoice> getLowAgeChecks(ArrayList<Invoice> invoices) {
        return invoices.stream()
                .filter(invoice -> invoice.getCustomer().getAge() < AGE_LIMIT)
                .peek(invoice -> invoice.setType(CheckType.LOW_AGE))
                .collect(Collectors.toList());
    }

    public List<Invoice> getSortedChecks(ArrayList<Invoice> invoices) {
        Comparator<Invoice> invoiceComparator = ((o1, o2) -> o2.getCustomer().getAge() - o1.getCustomer().getAge());
        return invoices.stream()
                .sorted(invoiceComparator.thenComparing(Invoice::amountOfProducts)
                        .thenComparing(Invoice::countCheckSum))
                .collect(Collectors.toList());
    }
}
