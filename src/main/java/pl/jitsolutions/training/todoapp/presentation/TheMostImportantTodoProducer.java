package pl.jitsolutions.training.todoapp.presentation;

import java.util.Optional;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;

import pl.jitsolutions.training.todoapp.business.todo.boundary.TodosProvider;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

public class TheMostImportantTodoProducer {

    @EJB
    private TodosProvider todosProvider;

    @Produces
    @TheMostImportantTodo
    public Todo getTheMostImportantTodo() {
        System.out.println("Producing the most important todo!");

        Optional<Todo> possibleTodo = todosProvider.getAll().stream().filter(Todo::isTheMostImportantTodo).findFirst();

        return possibleTodo.orElse(new Todo());
    }
}
