package utp.zpo.lab7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import utp.zpo.lab7.model.STATUS;
import utp.zpo.lab7.model.TYPE;
import utp.zpo.lab7.model.Task;
import utp.zpo.lab7.model.TaskDTO;
import utp.zpo.lab7.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public Task getTask(long id) {
        return taskRepository.getOne(id);
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent())
        taskRepository.delete(task.get());
    }

    public List<Task> getTasksByUser(long userId) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Task> getTasksByUserType(long userId, TYPE type) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getUser().getId() == userId)
                .filter(task -> task.getType() == type)
                .collect(Collectors.toList());
    }

    public List<Task> getTasksByUserStatus(long userId, STATUS status) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getUser().getId() == userId)
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }

    public List<Task> getTasksByUserTypeStatus(long userId, TYPE type, STATUS status) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getUser().getId() == userId)
                .filter(task -> task.getType() == type)
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }

    public List<Task> getTasksByTitle(String title) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getTitle().equals(title))
                .collect(Collectors.toList());
    }
}
