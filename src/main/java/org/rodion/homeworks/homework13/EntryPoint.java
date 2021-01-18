package org.rodion.homeworks.homework13;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.time.Instant;
import java.util.Date;

public class EntryPoint {
    public static void main(String[] args) throws JAXBException {
        Group group = new Group();
        group.setName("Test Group 1");
        group.getMembers().add(new Person("lastName1", "firstName1", new Date(Instant.parse("2021-01-01T00:00:01Z").toEpochMilli())));
        group.getMembers().add(new Person("lastName2", "firstName2", new Date(Instant.parse("2021-02-02T00:00:02Z").toEpochMilli())));
        marshall(group);
    }

    private static void marshall(Group group) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Group.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(group, System.out);
    }
}
