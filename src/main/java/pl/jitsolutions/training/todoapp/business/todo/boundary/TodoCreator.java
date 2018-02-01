package pl.jitsolutions.training.todoapp.business.todo.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@Stateless
public class TodoCreator {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Todo todo) {
        entityManager.persist(todo);
    }
}
