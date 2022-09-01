package org.acme;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;

    @ReactiveTransactional
    public Uni<Person> create(Person person) {
        return Panache.withTransaction(() -> personRepository.persist(person));
    }

    public Uni<Person> get(Long id) {
        return personRepository.findById(id);
    }

    public Uni<List<Person>> getAlivePerson() {
        return personRepository.findAlive();
    }
}
