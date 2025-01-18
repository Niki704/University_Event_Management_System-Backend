package lk.edu.mynibm.backend_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackID;

    @Column(nullable = false)
    private LocalDate date;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer teacherID;

    @Column(nullable = false)
    private Integer studentID;
}
