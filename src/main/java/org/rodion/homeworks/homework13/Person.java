package org.rodion.homeworks.homework13;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(propOrder = {"lastName", "firstName", "birthDate"}, name = "person")
public class Person {
    private String lastName;
    private String firstName;
    private Date birthDate;

    public Person(String lastName, String firstName, Date birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
