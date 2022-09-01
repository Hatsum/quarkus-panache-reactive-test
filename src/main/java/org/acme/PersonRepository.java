package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    public Uni<Person> findByName(String name){
        return find("name", name).firstResult();
    }

    public Uni<List<Person>> findAlive(){
        return list("status", Person.Status.Alive);
    }

    public Uni<Long> deleteStefs(){
        return delete("name", "Stef");
    }
}
