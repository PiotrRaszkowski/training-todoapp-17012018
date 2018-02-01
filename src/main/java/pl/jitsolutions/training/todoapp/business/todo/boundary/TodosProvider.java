package pl.jitsolutions.training.todoapp.business.todo.boundary;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@Stateless
public class TodosProvider {

    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public List<Todo> getAll() {
        TypedQuery<Todo> query = entityManager.createQuery("SELECT t FROM Todo t", Todo.class);
        return query.getResultList();
    }

    public Todo getTodo(Long id) {
        return entityManager.find(Todo.class, id);
    }
}
