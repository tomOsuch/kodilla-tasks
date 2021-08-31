package pl.tomaszosuch.kodillatasks.mapper;

import org.springframework.stereotype.Service;
import pl.tomaszosuch.kodillatasks.domain.Task;
import pl.tomaszosuch.kodillatasks.dto.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskMapper {

    public Task mapToTask(final TaskDto taskDto) {
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getContent()
        );
    }

    public TaskDto mapToTaskDto(final Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getContent()
        );
    }

    public List<TaskDto> mapToTaskDtoList(final List<Task> tasks) {
        return tasks.stream()
                .map(this::mapToTaskDto)
                .collect(Collectors.toList());
    }
}
