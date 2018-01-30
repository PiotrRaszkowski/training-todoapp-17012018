package pl.jitsolutions.training.todoapp.presentation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@Named
@ViewScoped
public class TodosPresenter implements Serializable {

    @Inject
    private TodosHolder todosHolder;

    @Inject
    @TheMostImportantTodo
    @Getter
    private Instance<Todo> theMostImportantTodo;

    @PostConstruct
    public void init() {
    }

    public List<Todo> getTodos() {
        return todosHolder.getTodos();
    }
}
