package utp.zpo.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskDTO {
    private long id;
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    private TYPE type;
    private STATUS status;
}
