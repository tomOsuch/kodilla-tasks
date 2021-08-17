package pl.tomaszosuch.kodillatasks.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszosuch.kodillatasks.domain.Task;
import pl.tomaszosuch.kodillatasks.domain.TaskDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testTaskMapToTaskDtoList() {
        //Given
        List<Task> tasks = List.of(new Task(1L, "Title", "description"));
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertEquals(tasks.size(), taskDtoList.size());
        assertEquals(tasks.get(0).getId(), taskDtoList.get(0).getId());
        assertEquals(tasks.get(0).getTitle(), taskDtoList.get(0).getTitle());
        assertEquals(tasks.get(0).getContent(), taskDtoList.get(0).getContent());
    }

    @Test
    public void testTaskMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Title", "description");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    public void testTaskDtoMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Title", "description");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }
}
