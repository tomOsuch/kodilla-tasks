package pl.tomaszosuch.kodillatasks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomaszosuch.kodillatasks.domain.Task;
import pl.tomaszosuch.kodillatasks.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbServicesImpl implements DbService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
