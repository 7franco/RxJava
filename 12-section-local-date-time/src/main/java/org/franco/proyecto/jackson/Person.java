package org.franco.proyecto.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

public class Person {
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Person person = new Person("Franco", LocalDate.of(1992,8,3));

        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        String matt = """
                {
                    "name": "Margaret",
                    "birthDate": "17/09/2008"
                }
                """;
        Person person1 = mapper.readValue(matt, Person.class);

        System.out.println(person1.getName());
        System.out.println(person1.getBirthDate());














    }
}
