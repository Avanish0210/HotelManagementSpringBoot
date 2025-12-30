package CollegeManagement.CollegeManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String title;

    @OneToMany(mappedBy = "subjectEntity")
    List<StudentEntity> studentEntities = new ArrayList<>();
}
