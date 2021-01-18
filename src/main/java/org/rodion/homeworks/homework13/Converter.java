package org.rodion.homeworks.homework13;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Converter {
    private final static String FILENAME = "user.json";

    public static void toJson(User user) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(System.out, user);
        mapper.writeValue(new File(FILENAME), user);
        System.out.println("Json created");
    }

    public static User toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(FILENAME), User.class);
    }

    public static void main(String[] args) throws IOException {
        User user = new User(192, "John Doe", "Nightmare", "+55585736", "+1666545");
        System.out.println(user);
        toJson(user);

//        User user = toJavaObject();
//        System.out.println(user);
    }
}
