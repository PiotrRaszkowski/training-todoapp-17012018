package pl.jitsolutions.training.todoapp.business.todo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo implements Serializable {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDateTime;

    private boolean theMostImportantTodo;
}
