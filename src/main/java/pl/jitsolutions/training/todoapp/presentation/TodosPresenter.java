package pl.jitsolutions.training.todoapp.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import pl.jitsolutions.training.todoapp.business.todo.boundary.TodosProvider;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@Named
@ViewScoped
public class TodosPresenter implements Serializable {

    @Inject
    @TheMostImportantTodo
    @Getter
    private Todo theMostImportantTodo;

    @EJB
    private TodosProvider todosProvider;

    @Getter
    private List<Todo> todos;

    @PostConstruct
    public void init() {
        todos = todosProvider.getAll();
    }
}
