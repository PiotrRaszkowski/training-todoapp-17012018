package pl.jitsolutions.training.todoapp.test;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@Singleton
@Startup
public class TestDataLoader {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        System.out.println("Loading test data...");

        Todo todo1 = Todo.builder()
                .title("Todo 1")
                .description("Description 1")
                .creationDateTime(LocalDateTime.now())
                .build();

        entityManager.persist(todo1);

        Todo todo2 = Todo.builder()
                .title("Todo 2")
                .description("Description 2")
                .creationDateTime(LocalDateTime.now())
                .build();

        entityManager.persist(todo2);

        Todo todo3 = Todo.builder()
                .title("Todo 3")
                .description("Description 3")
                .creationDateTime(LocalDateTime.now())
                .build();

        entityManager.persist(todo3);
    }
}
