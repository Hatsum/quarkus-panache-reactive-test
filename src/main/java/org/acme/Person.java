package org.acme;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Person {
    @Id
    private Long id;
    private String name;
    private LocalDate birth;
    @Column(columnDefinition = "ENUM('Alive','Death')")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person withId(Long id) {
        setId(id);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person withName(String name) {
        setName(name);
        return this;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Person withBirth(LocalDate birth) {
        setBirth(birth);
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Person withStatus(Status status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(birth, person.birth) && status == person.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birth, status);
    }

    public enum Status {
        Alive,
        Death
    }
}
