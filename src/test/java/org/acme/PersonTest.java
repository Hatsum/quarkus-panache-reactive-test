package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;

@QuarkusTest
class PersonTest {
    @Inject
    PersonService personService;

    Person expected = new Person()
            .withId(1L)
            .withName("John")
            .withBirth(LocalDate.of(2015, 10, 21))
            .withStatus(Person.Status.Alive);

    @Test
    @Order(1)
    void testCreation() {
        personService.create(expected)
                     .subscribe().withSubscriber(UniAssertSubscriber.create())
                     .awaitItem()
                     .assertItem(expected);
    }

    @Test
    @Order(2)
    @Disabled
    void testFindById() {
        personService.get(1L)
                     .subscribe().withSubscriber(UniAssertSubscriber.create())
                     .awaitItem()
                     .assertItem(expected);
    }
}
