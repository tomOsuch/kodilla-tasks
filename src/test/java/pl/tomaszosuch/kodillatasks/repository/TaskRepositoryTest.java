package pl.tomaszosuch.kodillatasks.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszosuch.kodillatasks.domain.Task;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testTaskFindAll() {
        //Given
        Task task = new Task("Test_title", "Test_content");
        taskRepository.save(task);
        Long id = task.getId();
        //When
        List<Task> resultsTaskList = taskRepository.findAll();
        //Then
        assertEquals(1, resultsTaskList.size());
        //CleanUp
        taskRepository.deleteAll();
    }

    @Test
    public void testTaskFindById() {
        //Given
        Task task = new Task("Test_title", "Test_content");
        taskRepository.save(task);
        Long id = task.getId();
        //When
        Optional<Task> resultFindTask = taskRepository.findById(id);
        //Then
        assertTrue(resultFindTask.isPresent());
        //CleanUp
        taskRepository.deleteAll();
    }

    @Test
    public void testTaskDeleteById() {
        //Given
        Task task = new Task("Test_title", "Test_content");
        taskRepository.save(task);
        Long id = task.getId();
        //When
        taskRepository.deleteById(id);
        Optional<Task> taskFind = taskRepository.findById(id);
        //Then
        assertFalse(taskFind.isPresent());
        //CleanUp
        taskRepository.deleteAll();
    }
}
