package utp.zpo.lab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utp.zpo.lab7.model.*;
import utp.zpo.lab7.repository.TaskRepository;
import utp.zpo.lab7.service.UserService;
import utp.zpo.lab7.util.UserUtil;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        List<User> users = userService.getUsers();
        return userMapper.toDTOs(users);
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUser(@PathVariable long userId) {
        User user = userService.getUser(userId);
        return userMapper.toDTO(user);
    }

    @PostMapping("/users")
    public void createUser(CreateUserDTO userDTO) {
        User user = userMapper.fromDTO(userDTO);
        userService.createUser(user);
    }

    @PutMapping("/users/{userId}")
    public void updateUser(UpdateUserDTO userDTO, @PathVariable long
            userId) {
        User userFromDb = userService.getUser(userId);
        if (userFromDb != null) {
            User user = userMapper.fromDTO(userDTO);
            user.setId(userId);
            userService.updateUser(user);
        }
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/userCount")
    public List<UserCountStatus> userCountStatuses() {
        List<UserCountStatus> users = new UserUtil().getUserCountStatus(taskRepository.findAll());
        return users;
    }
}
