package org.rodion.homeworks.homework13;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.StringJoiner;

@Getter
@Setter
public class User {

    @JsonProperty("Number")
    private long id;

    @JsonProperty("First Name")
    private String name;

    @JsonProperty("Phone Numbers")
    private List<String> phones;

    @JsonIgnore
    private String level;

    public User() {
    }

    public User(long id, String name, String level, String... phones) {
        this.id = id;
        this.name = name;
        this.phones = List.of(phones);
        this.level = level;
    }

    public void setId(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID must be greater than 0!");
        }
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("phones='" + phones + "'")
                .toString();
    }
}
