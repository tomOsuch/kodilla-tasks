package pl.tomaszosuch.kodillatasks.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszosuch.kodillatasks.domain.Task;
import pl.tomaszosuch.kodillatasks.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DbServiceTestSuite {
/*
    @InjectMocks
    private DbServicesImpl dbServices;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testGetAllTask() {
        //Given
        List<Task> tasks = List.of(new Task(1L, "Test_title", "Test_content"));
        when(taskRepository.findAll()).thenReturn(tasks);
        //When
        List<Task> resultAllTask = dbServices.getAllTasks();
        //Then
        assertEquals(1, resultAllTask.size());
    }

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(1L, "Test_title", "Test_content");
        when(taskRepository.save(task)).thenReturn(task);
        //When
        Task resultSaveTask = dbServices.saveTask(task);
        //Then
        assertEquals(task.getId(), resultSaveTask.getId());
        assertEquals(task.getTitle(), resultSaveTask.getTitle());
        assertEquals(task.getContent(), resultSaveTask.getContent());
    }

    @Test
    public void testGetTaskById() {
        //Given
        List<Task> tasks = List.of(new Task(1L, "Test_title", "Test_content"));
        when(taskRepository.findById(tasks.get(0).getId())).thenReturn(Optional.ofNullable(tasks.get(0)));
        //When
        boolean resultFindById = dbServices.getTask(1L).isPresent();
        //Then
        assertTrue(resultFindById);

    }

    @Test
    public void testDeleteTask() {
        //Given
        Task task = new Task(1L, "Test_title", "Test_content");
        Long taskId = task.getId();
        //When
        dbServices.deleteTask(taskId);
        //Then
        verify(taskRepository, times(1)).deleteById(taskId);
    }*/
}
