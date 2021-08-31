package pl.tomaszosuch.kodillatasks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.kodillatasks.domain.Task;
import pl.tomaszosuch.kodillatasks.dto.TaskDto;
import pl.tomaszosuch.kodillatasks.exception.TaskNotFoundException;
import pl.tomaszosuch.kodillatasks.mapper.TaskMapper;
import pl.tomaszosuch.kodillatasks.service.DbServicesImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tasks")
public class TaskController {

    private final DbServicesImpl dbServices;
    private final TaskMapper taskMapper;

    @GetMapping("getTasks")
    public List<TaskDto> getTasks() {
        List<Task> tasks = dbServices.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping("getTask/{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(dbServices.getTask(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @DeleteMapping("deleteTask/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        dbServices.deleteTask(taskId);
    }

    @PutMapping("/updateTask")
    public TaskDto updateTask(TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        Task saveTask = dbServices.saveTask(task);
        return taskMapper.mapToTaskDto(saveTask);
    }

    @PostMapping(value = "/createTask", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        dbServices.saveTask(task);
    }
}
