package utp.zpo.lab7.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.zpo.lab7.model.STATUS;
import utp.zpo.lab7.model.TYPE;
import utp.zpo.lab7.model.Task;
import utp.zpo.lab7.model.User;
import utp.zpo.lab7.repository.TaskRepository;
import utp.zpo.lab7.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@Slf4j
public class InitService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @PostConstruct
    public void init() {
        log.info("Init");

        User u1 = new User(0L, "Jan Kowalski");
        User u2 = new User(0L, "Adam Nowak");

        userRepository.save(u1);
        userRepository.save(u2);

        Task t1 = new Task(0L, "Task1", LocalDate.now().minus(2, ChronoUnit.DAYS) , TYPE.FEATURE, STATUS.ACTIVE, u1);
        Task t2 = new Task(0L, "Task2", LocalDate.now(), TYPE.TASK, STATUS.ACTIVE, u1);
        Task t3 = new Task(0L, "Task3", LocalDate.now().minus(5, ChronoUnit.DAYS), TYPE.FEATURE, STATUS.NEW, u2);
        Task t4 = new Task(0L, "Task4", LocalDate.now().minus(10, ChronoUnit.DAYS), TYPE.BUG, STATUS.DONE, u2);
        Task t5 = new Task(0L, "Task5", LocalDate.now().minus(24, ChronoUnit.DAYS), TYPE.FEATURE, STATUS.ACTIVE, u1);
        Task t6 = new Task(0L, "Task6", LocalDate.now().minus(18, ChronoUnit.DAYS), TYPE.TASK, STATUS.DONE, u2);

        taskRepository.save(t1);
        taskRepository.save(t2);
        taskRepository.save(t3);
        taskRepository.save(t4);
        taskRepository.save(t5);
        taskRepository.save(t6);
    }
}
