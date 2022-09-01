package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;

@QuarkusTest
class PersonTest {
    @Inject
    PersonService personService;

    Person jane = new Person()
            .withId(1L)
            .withName("Jane")
            .withBirth(LocalDate.of(2005, 10, 21))
            .withStatus(Person.Status.Death);

    Person john = new Person()
            .withId(2L)
            .withName("John")
            .withBirth(LocalDate.of(2005, 10, 21))
            .withStatus(Person.Status.Alive);

    @Test
    @Order(1)
    void testCreation() {
        personService.create(john)
                     .chain(person -> personService.get(john.getId()))
                     .subscribe().withSubscriber(UniAssertSubscriber.create())
                     .awaitItem()
                     .assertItem(john);
    }

    @Test
    @Order(2)
    void testFindById() {
        personService.get(jane.getId())
                     .subscribe().withSubscriber(UniAssertSubscriber.create())
                     .awaitItem()
                     .assertItem(jane);
    }
}
