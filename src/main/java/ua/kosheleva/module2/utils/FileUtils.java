package ua.kosheleva.module2.utils;

import ua.kosheleva.module2.exception.NoInformationException;
import ua.kosheleva.module2.models.Invoice;
import ua.kosheleva.module2.models.Product;
import ua.kosheleva.module2.models.Telephone;
import ua.kosheleva.module2.models.Television;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Objects;

public class FileUtils {
    private final HashMap<String, Integer> featureNamesMap = new HashMap<>();
    public List<Product> readCsvFile(String fileName) {
        ArrayList<Product> products = new ArrayList<>();
        int indexOfLineForFindingError = 0;
        try (BufferedReader bufferedReader = createBufferReader(fileName)) {
            String features;
            if ((features = bufferedReader.readLine()) != null) {
                readHeaderRow(features);
                while ((features = bufferedReader.readLine()) != null) {
                    indexOfLineForFindingError++;
                    products.add(createProductsForOrder(features));
                }
            } else {
               throw new NoInformationException("File is empty!");
            }
        }catch (IOException e) {
            System.out.println("File not found");
            System.exit(-1);
        } catch (NoInformationException e) {
            System.out.println(e.getMessage() + "Not enough data in line: " + indexOfLineForFindingError);
            System.exit(-1);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return products;
    }

    private Product createProductsForOrder(String features) throws NoInformationException {
        String[] productFeatures = features.trim().split(",");
        isFeaturesEmpty(productFeatures);
        if (productFeatures[featureNamesMap.get("type")].equals("Telephone")) {
            return createTelephoneForOrder(productFeatures);
        }
        return createTelevisionForOrder(productFeatures);
    }

    private Product createTelephoneForOrder(String[] productFeatures) {
        return new Telephone(productFeatures[featureNamesMap.get("series")],
                productFeatures[featureNamesMap.get("model")],
                productFeatures[featureNamesMap.get("screenType")],
                Double.parseDouble(productFeatures[featureNamesMap.get("price")]));
    }

    private Product createTelevisionForOrder(String[] productFeatures) {
        return new Television(productFeatures[featureNamesMap.get("series")],
                Double.parseDouble(productFeatures[featureNamesMap.get("diagonal")]),
                productFeatures[featureNamesMap.get("screenType")],
                productFeatures[featureNamesMap.get("country")],
                Double.parseDouble(productFeatures[featureNamesMap.get("price")]));
    }

    private void readHeaderRow(String header) throws NoInformationException {
        String[] headerNames = header.trim().split(",");
        isHeaderRowWithoutNumbers(headerNames);
        for (int i = 0; i < headerNames.length; i++) {
            featureNamesMap.put(headerNames[i].toLowerCase(), i);
        }
    }

    private void isHeaderRowWithoutNumbers(String[] headerRow) throws NoInformationException {
        for (String characteristicName : headerRow) {
            if (characteristicName.matches(".*\\d.*")) {
                throw new NoInformationException("Header hasn't enough info!");
            }
        }
    }

    private static void isFeaturesEmpty(String[] headerNames) throws NoInformationException {
        for (String feature : headerNames) {
            if (feature.trim().isEmpty()) {
                throw new NoInformationException("Not enough information!");
            }
        }
    }

    private BufferedReader createBufferReader(String fileName) throws FileNotFoundException {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            InputStream obj = Objects.requireNonNull(loader.getResourceAsStream(fileName));
            return new BufferedReader(new InputStreamReader(obj));
        } catch (NullPointerException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    public void logOrdersInfo(ArrayList<Invoice> invoices) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Log.txt"))) {
            for (Invoice invoice : invoices) {
                bufferedWriter.write(invoice + "\n");
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
