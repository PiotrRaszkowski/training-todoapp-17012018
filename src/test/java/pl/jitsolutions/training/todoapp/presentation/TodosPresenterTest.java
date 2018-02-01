package pl.jitsolutions.training.todoapp.presentation;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.jitsolutions.training.todoapp.business.todo.boundary.TodosProvider;
import pl.jitsolutions.training.todoapp.business.todo.entity.Todo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodosPresenterTest {

    @Mock
    private TodosProvider todosProvider;

    @InjectMocks
    private TodosPresenter todosPresenter;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class...");
    }

    @Before
    public void setUp() {
        System.out.println("Set Up...");
        List<Todo> myTodos = new ArrayList<>();
        myTodos.add(new Todo());
        myTodos.add(new Todo());
        myTodos.add(new Todo());

        when(todosProvider.getAll()).thenReturn(myTodos);

//        doReturn(myTodos).when(todosProvider).getAll();
    }

    @Test
    public void init() {
        //GIVEN

        //WHEN
        todosPresenter.init();

        //THEN
        List<Todo> todos = todosPresenter.getTodos();

        assertEquals(3, todos.size());

        verify(todosProvider, times(1)).getAll();
    }

    @After
    public void tearDown() {
        System.out.println("Tear Down...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class...");
    }
}