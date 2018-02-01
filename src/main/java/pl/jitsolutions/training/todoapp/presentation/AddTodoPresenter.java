package pl.jitsolutions.training.todoapp.presentation;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import pl.jitsolutions.training.todoapp.business.todo.boundary.TodoCreator;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@ViewScoped
@Named
public class AddTodoPresenter implements Serializable {

    @Getter
    @Setter
    private Todo newTodo = new Todo();

    @EJB
    private TodoCreator todoCreator;

    public String save() {
        todoCreator.create(newTodo);

        return "todos";
    }
}
