package utp.zpo.lab7.util;

import org.junit.Test;
import utp.zpo.lab7.model.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class UserUtilTest {

    @Test
    public void getUserCountStatus() {
        User u1 = new User(0L, "Jan Kowalski");
        User u2 = new User(0L, "Adam Nowak");

        Task t1 = new Task(0L, "Task1", LocalDate.now().minus(2, ChronoUnit.DAYS), TYPE.FEATURE, STATUS.ACTIVE, u1);
        Task t2 = new Task(0L, "Task2", LocalDate.now(), TYPE.TASK, STATUS.ACTIVE, u1);
        Task t3 = new Task(0L, "Task3", LocalDate.now().minus(5, ChronoUnit.DAYS), TYPE.FEATURE, STATUS.NEW, u2);
        Task t4 = new Task(0L, "Task4", LocalDate.now().minus(10, ChronoUnit.DAYS), TYPE.BUG, STATUS.DONE, u2);
        Task t5 = new Task(0L, "Task5", LocalDate.now().minus(24, ChronoUnit.DAYS), TYPE.FEATURE, STATUS.ACTIVE, u1);
        Task t6 = new Task(0L, "Task6", LocalDate.now().minus(18, ChronoUnit.DAYS), TYPE.TASK, STATUS.DONE, u2);

        List<Task> given = Arrays.asList(t1, t2, t3, t4, t5, t6);
        UserUtil userUtil = new UserUtil();

        List<UserCountStatus> expected = new ArrayList<>();
        expected.add(new UserCountStatus(u1, STATUS.ACTIVE, 3));
        expected.add(new UserCountStatus(u2, STATUS.DONE, 2));
        expected.add(new UserCountStatus(u2, STATUS.NEW, 1));

        List<UserCountStatus> result = userUtil.getUserCountStatus(given);

        expected.sort(Comparator.comparing(userCountStatus -> userCountStatus.getUser().getId()));
        result.sort(Comparator.comparing(userCountStatus -> userCountStatus.getUser().getId()));

        assertEquals(expected, result);
    }
}