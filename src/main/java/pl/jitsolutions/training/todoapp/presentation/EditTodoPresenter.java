package pl.jitsolutions.training.todoapp.presentation;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import pl.jitsolutions.training.todoapp.business.todo.boundary.TodoEditor;
import pl.jitsolutions.training.todoapp.business.todo.boundary.TodosProvider;
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

    @EJB
    private TodoEditor todoEditor;

    @EJB
    private TodosProvider todosProvider;

    public void preRenderView() {
        todo = todosProvider.getTodo(id);
    }

    public String save() {
        todo.setOwnerId(-1L);
        todoEditor.edit(todo);

        return "todos";
    }
}
