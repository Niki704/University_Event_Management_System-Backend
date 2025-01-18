package lk.edu.mynibm.backend_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentFeedbackResponseDTO {
    private int feedbackID;
    private LocalDate date;
    private String content;
    private Integer teacherID;
    private Integer studentID;
}
