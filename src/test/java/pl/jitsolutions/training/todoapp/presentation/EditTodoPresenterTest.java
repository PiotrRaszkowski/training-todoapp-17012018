package pl.jitsolutions.training.todoapp.presentation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.jitsolutions.training.todoapp.business.todo.boundary.TodoEditor;
import pl.jitsolutions.training.todoapp.business.todo.boundary.TodosProvider;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EditTodoPresenterTest {

    private static final long TODO_ID = 1L;

    @Mock
    private TodoEditor todoEditor;

    @Mock
    private TodosProvider todosProvider;

    private Todo todo;

    @InjectMocks
    private EditTodoPresenter editTodoPresenter;

    @Captor
    private ArgumentCaptor<Todo> todoArgumentCaptor;

    @Before
    public void setUp() throws Exception {
        todo = new Todo();

        when(todosProvider.getTodo(eq(TODO_ID))).thenReturn(todo);
    }

    @Test
    public void preRenderViewGivenExistingId() {
        //GIVEN
        editTodoPresenter.setId(TODO_ID);

        //WHEN
        editTodoPresenter.preRenderView();

        //THEN
        verify(todosProvider, only()).getTodo(TODO_ID);
    }

    @Test
    public void save() {
        //GIVEN
        editTodoPresenter.setTodo(todo);

        //WHEN
        editTodoPresenter.save();

        //THEN
        verify(todoEditor, only()).edit(todoArgumentCaptor.capture());

        assertEquals(-1L, todoArgumentCaptor.getValue().getOwnerId().longValue());
    }
}