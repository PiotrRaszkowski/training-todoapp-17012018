package pl.jitsolutions.training.todoapp.presentation;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@ViewScoped
@Named
public class AddTodoPresenter implements Serializable {

    @Getter
    @Setter
    private Todo newTodo = new Todo();

    @Inject
    private TodosPresenter todosPresenter;

    public String save() {
        newTodo.setCreationDateTime(LocalDateTime.now());
        newTodo.setId(todosPresenter.getTodos().get(todosPresenter.getTodos().size()-1).getId()+1);

        todosPresenter.getTodos().add(newTodo);

        return "todos";
    }
}
