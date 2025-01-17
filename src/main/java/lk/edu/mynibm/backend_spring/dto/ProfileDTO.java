package lk.edu.mynibm.backend_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private int userID;
    private String firstName;
    private String lastName;
    private String address;
    private String bio;
}
