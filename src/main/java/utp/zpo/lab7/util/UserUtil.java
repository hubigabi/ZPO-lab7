package utp.zpo.lab7.util;

import utp.zpo.lab7.model.Task;
import utp.zpo.lab7.model.TaskGroupBy;

import utp.zpo.lab7.model.UserCountStatus;

import java.util.List;
import java.util.stream.Collectors;

public class UserUtil {
    public List<UserCountStatus> getUserCountStatus(List<Task> taskList) {
        return taskList.stream()
                .collect(Collectors.groupingBy(task -> new TaskGroupBy(task.getUser(), task.getStatus())))
                .entrySet()
                .stream()
                .map(userListEntry -> new UserCountStatus(userListEntry.getKey().getUser(),
                        userListEntry.getKey().getStatus(),
                        (int) userListEntry.getValue().stream().count()))
                .collect(Collectors.toList());
    }
}
