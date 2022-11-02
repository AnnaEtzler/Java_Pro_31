package Lesson26;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
// 1.Напишите функцию которая принимает на вход Element и складывает значения атрибутов plantid из его дочерних элементов PLANT (579)
// 2.Найдите себе любой xml документ и поэкспериментируйте с ним из явы
// - например, соберите текстовые значения всех его определенных элементов
// в строку через StringBuilder. Например, собрать через ; значения всех элементов BOTANICAL - "Sanguinaria canadensis;Aquilegia canadensis"
public class Homework {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));
        Element root = doc.getDocumentElement(); // CATALOG

        sumOfPlantid(root);

        stringOfBotanical(root);





    }

    private static void stringOfBotanical(Element root) {
        NodeList nodeList = root.getElementsByTagName("BOTANICAL");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i); // конкретный элемент
            String res = node.getTextContent();
            stringBuilder.append(res).append(", ");
        }
        System.out.println(stringBuilder);

    }

    private static void sumOfPlantid(Element root) {
        NodeList nodeList = root.getElementsByTagName("PLANT");// cписок элементов с именем PLANT
        int result = 0;
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i); // конкретный элемент
            int res = Integer.parseInt(node.getAttributes().getNamedItem("plantid").getTextContent());
            result += res;
        }
        System.out.println(result);
    }


}
