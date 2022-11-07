package Lesson28.HomeworkJaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import retrofit2.http.GET;

import java.util.List;

@XmlRootElement(name = "EMPLOYEES")
public class Employees {
    private String nameOfFirma;
    private List<Emp> emps;

    public Employees(String nameOfFirma, List<Emp> emps) {
        this.nameOfFirma = nameOfFirma;
        this.emps = emps;
    }

    public Employees() {

    }

    public List<Emp> getEmps() {
        return emps;
    }

    @XmlElement(name = "EMP")
    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public String getNameOfFirma() {
        return nameOfFirma;
    }

    @XmlAttribute(name = "Firma")
    public void setNameOfFirma(String nameOfFirma) {
        this.nameOfFirma = nameOfFirma;
    }
}
