package pl.tomaszosuch.kodillatasks.service;

import pl.tomaszosuch.kodillatasks.domain.Task;

import java.util.List;
import java.util.Optional;

public interface DbService {

    List<Task> getAllTasks();
    Optional<Task> getTask(Long id);
    Task saveTask(Task task);
    void deleteTask(Long id);
}
