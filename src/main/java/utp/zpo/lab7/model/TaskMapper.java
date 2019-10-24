package utp.zpo.lab7.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utp.zpo.lab7.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    @Autowired
    UserRepository userRepository;

    public TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(), task.getTitle(), task.getLocalDate(),
                task.getType(), task.getStatus(), task.getUser());
    }

    public List<TaskDTO> toDTOs(List<Task> tasks) {
        return tasks.stream()
                .map(task -> toDTO(task))
                .collect(Collectors.toList());
    }

    public Task fromDTO(CreateTaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setLocalDate(taskDTO.getLocalDate());
        task.setType(taskDTO.getType());
        task.setStatus(taskDTO.getStatus());
        task.setUser(userRepository.findById(taskDTO.getUser_id()).orElse(new User()));
        return task;
    }

    public Task fromDTO(UpdateTaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setLocalDate(taskDTO.getLocalDate());
        task.setType(taskDTO.getType());
        task.setStatus(taskDTO.getStatus());
        task.setUser(userRepository.findById(task.getId()).orElse(new User()));
        return task;
    }
}
