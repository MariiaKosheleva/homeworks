package ua.kosheleva.hw18;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class Main {
    public static void main(String[] args) throws Exception {
        task1();
        System.out.println();
        task2();
    }

    private static void task1() {
        try {
            File xmlFile = new File("src/main/resources/slide27.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            nodeList = doc.getElementsByTagName("box");
            List<Box> boxList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                boxList.add(getBoxFromXML());
            }
            for (Box box : boxList) {
                System.out.println(box);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Box getBoxFromXML() {
        Box box = new Box();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Current element: " + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                box.setFrom(element.getAttribute("from"));
                box.setMaterial(element.getAttribute("material"));
                box.setColor(element.getElementsByTagName("color").item(i).getTextContent());
                box.setMaxLiftingCapacity(Integer.parseInt(element.getElementsByTagName("max-lifting-capacity").item(i).getTextContent()));
                box.setUnit(element.getElementsByTagName("max-lifting-capacity").item(i).getAttributes().getNamedItem("unit").getTextContent());
                box.setCargoName(element.getElementsByTagName("name").item(i).getTextContent());
                box.setCargoClass(element.getElementsByTagName("class").item(i).getTextContent());
                box.setDeliveryDateFromXML(element.getElementsByTagName("delivery-date").item(i).getTextContent());
            }
        }
        return box;
    }

    private static void task2() throws Exception {
        String jsonString = readJsonFile("src/main/resources/slide28.json");
        JSONObject obj = new JSONObject(jsonString);
        Box box = new Box();
        box.setFrom(obj.getString("from"));
        box.setMaterial(obj.getString("material"));
        box.setColor(obj.getString("color"));
        box.setMaxLiftingCapacity(obj.getJSONObject("max-lifting-capacity").getInt("value"));
        box.setUnit(obj.getJSONObject("max-lifting-capacity").getString("unit"));
        box.setCargoName(obj.getJSONObject("cargo").getString("name"));
        box.setCargoClass(obj.getJSONObject("cargo").getString("class"));
        box.setDeliveryDateFromJSON(obj.getString("delivery-date"));
        System.out.println(box);
    }

    private static String readJsonFile(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    private static NodeList nodeList = new NodeList() {
        @Override
        public Node item(int index) {
            return null;
        }

        @Override
        public int getLength() {
            return 0;
        }
    };
}






