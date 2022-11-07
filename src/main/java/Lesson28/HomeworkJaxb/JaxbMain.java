package Lesson28.HomeworkJaxb;

import Lesson27.Catalog;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lesson23.Employee;

import java.io.File;
import java.util.List;

// Параметризуйте через JaxB класс Emp или Car и сохраните его в xml
public class JaxbMain {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Emp emp = new Emp("Bob", "Smith", "HR manager", "7000", "1234" );
        Emp emp2 = new Emp("Angela", "Merkel", "Informatikerin", "10000", "4321" );
        Emp emp3 = new Emp("Kot", "Matroskin", "Boss", "100000", "7777");
        Employees employees = new Employees("Google", List.of(emp, emp2, emp3));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(employees, new File("newFirma.xml"));
    }
}
