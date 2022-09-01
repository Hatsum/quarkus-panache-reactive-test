package org.acme;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Person {
    @Id
    private Long id;
    private String name;
    private LocalDate birth;
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

    public enum Status {
        Death,
        Alive
    }
}
