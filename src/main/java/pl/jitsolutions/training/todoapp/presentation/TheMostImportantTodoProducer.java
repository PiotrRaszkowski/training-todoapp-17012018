package pl.jitsolutions.training.todoapp.presentation;

import java.util.Optional;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

public class TheMostImportantTodoProducer {

    @Inject
    private TodosHolder todosHolder;

    @Produces
    @TheMostImportantTodo
    public Todo getTheMostImportantTodo() {
        System.out.println("Producing the most important todo!");

        Optional<Todo> possibleTodo = todosHolder.getTodos().stream().filter(Todo::isTheMostImportantTodo).findFirst();

        return possibleTodo.orElse(new Todo());
    }
}
