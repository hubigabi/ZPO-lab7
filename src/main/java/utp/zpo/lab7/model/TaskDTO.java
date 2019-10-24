package utp.zpo.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private long id;
    private String title;
    private LocalDate localDate;
    private TYPE type;
    private STATUS status;
    private User user;
}
