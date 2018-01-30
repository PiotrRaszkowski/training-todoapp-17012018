package pl.jitsolutions.training.todoapp.presentation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import lombok.Getter;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

@SessionScoped
public class TodosHolder implements Serializable {

    @Getter
    private List<Todo> todos = new ArrayList<>();

    @PostConstruct
    public void init() {
        Todo todo1 = Todo.builder()
                .id(1L)
                .title("Todo 1")
                .description("Description 1")
                .creationDateTime(LocalDateTime.now())
                .build();

        Todo todo2 = Todo.builder()
                .id(2L)
                .title("Todo 2")
                .description("Description 2")
                .creationDateTime(LocalDateTime.now())
                .build();

        Todo todo3 = Todo.builder()
                .id(3L)
                .title("Todo 3")
                .description("Description 3")
                .creationDateTime(LocalDateTime.now())
                .build();

        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);
    }
}
