package utp.zpo.lab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utp.zpo.lab7.model.*;
import utp.zpo.lab7.service.TaskService;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks() {
        List<Task> tasks = taskService.getTasks();
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/{taskId}")
    public TaskDTO getTask(@PathVariable long taskId) {
        Task task = taskService.getTask(taskId);
        return taskMapper.toDTO(task);
    }

    @PostMapping("/task")
    public void createTask(CreateTaskDTO taskDTO) {
        Task task = taskMapper.fromDTO(taskDTO);
        taskService.createTask(task);
    }

    @PutMapping("/tasks/{taskId}")
    public void updateTask(UpdateTaskDTO taskDTO, @PathVariable long
            taskId) {
        Task taskFromDb = taskService.getTask(taskId);
        if (taskFromDb != null) {
            Task task = taskMapper.fromDTO(taskDTO);
            task.setId(taskId);
            taskService.updateTask(task);
        }
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable long taskId) {
        taskService.deleteTask(taskId);
    }

    @GetMapping("/tasksByUser/{UserId}")
    public List<TaskDTO>  getTasksByUser(@PathVariable long UserId) {
        List<Task> tasks = taskService.getTasksByUser(UserId);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasksByUserType/{UserId}")
    public List<TaskDTO>  getTasksByUserType(@PathVariable long UserId, TYPE type) {
        List<Task> tasks = taskService.getTasksByUserType(UserId,type);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasksByUserStatus/{UserId}")
    public List<TaskDTO>  getTasksByUserStatus(@PathVariable long UserId, STATUS status) {
        List<Task> tasks = taskService.getTasksByUserStatus(UserId, status);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasksByUserTypeStatus/{UserId}")
    public List<TaskDTO>  getTasksByUserTypeStatus(@PathVariable long UserId, TYPE type, STATUS status) {
        List<Task> tasks = taskService.getTasksByUserTypeStatus(UserId,type, status);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasksByTitle/{Title}")
    public List<TaskDTO>  getTasksByTitle(@PathVariable String  Title) {
        List<Task> tasks = taskService.getTasksByTitle(Title);
        return taskMapper.toDTOs(tasks);
    }
}
