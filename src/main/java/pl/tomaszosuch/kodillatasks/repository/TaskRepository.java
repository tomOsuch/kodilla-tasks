package pl.tomaszosuch.kodillatasks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomaszosuch.kodillatasks.domain.Task;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task task);
    void deleteById(Long id);
}
