package Lesson26.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlTester {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));

        Element root = doc.getDocumentElement(); // CATALOG
        NodeList nodeList = root.getElementsByTagName("PRICE");// cписок элементов с именем PRICE
        for (int i = 0; i < nodeList.getLength(); i++){
            Node priceNode = nodeList.item(i); // конкретный элемент
            System.out.println(priceNode.getFirstChild().getTextContent());

        }

        printNode("", root);
        //printAttributes("", root);
    }

    private static void printNode(String s, Element element) {
        System.out.println(
                s +
                        "element name: " + element.getNodeName() +
                        " type " + element.getNodeType() +
                        printTextValue(element)
        );
        printAttributes(s + "\t", element);
        NodeList children = element.getChildNodes(); // все дочерние элементы
        for(int i = 0; i < children.getLength(); i++){
            Node node = children.item(i); // Node - может быть атрибут и текстовое значение
            if(node instanceof Element){
                printNode(s + "\t", (Element) node);
            }

        }
    }

    private static String printTextValue(Element element) {

        return " value " + element.getFirstChild().getTextContent();
    }

    public static void printAttributes(String prefix, Element element){
        NamedNodeMap namedNodeMap = element.getAttributes(); // все аттрибуты
        for (int i = 0; i < namedNodeMap.getLength(); i++){
            Node node = namedNodeMap.item(i); // конкретный аттрибут
            System.out.println(
                    prefix + " attr name: " + node.getNodeName() + "," +
                            " value: " + node.getNodeValue()
            );
        }
    }
}
