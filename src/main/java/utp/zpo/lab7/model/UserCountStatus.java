package utp.zpo.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCountStatus {
    private User user;
    private STATUS status;
    private Integer statusCount;
}
