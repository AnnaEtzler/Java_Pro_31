package Lesson28.HomeworkJaxb;

import jakarta.xml.bind.annotation.*;

@XmlType(propOrder = {"name", "surname", "position", "salary"})
public class Emp {
    private String id;
    private String name;
    private String surname;
    private String position;
    private String salary;

    public Emp(String name, String surname, String position, String salary, String id) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
        this.id = id;
    }
    public String getId() {
        return id;
    }
    @XmlAttribute(name = "ID")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement(name = "SURNAME")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    @XmlElement(name = "POSITION")
    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    @XmlElement(name = "SALARY")
    public void setSalary(String salary) {
        this.salary = salary;
    }


}
