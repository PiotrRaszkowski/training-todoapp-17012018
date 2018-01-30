package pl.jitsolutions.training.todoapp.presentation;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@ViewScoped
@Named
public class EditTodoPresenter implements Serializable {

    @Getter
    @Setter
    private Todo todo;

    @Getter
    @Setter
    private Long id;

    @Inject
    private TodosPresenter todosPresenter;

    public void preRenderView() {
        todo = todosPresenter.getTodos().stream().filter(t -> t.getId().equals(id)).findAny().get();
    }

    public String save() {
        return "todos";
    }
}
