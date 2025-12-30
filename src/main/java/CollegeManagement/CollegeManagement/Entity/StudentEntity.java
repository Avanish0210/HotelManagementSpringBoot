package CollegeManagement.CollegeManagement.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "professor_id") // this means in database it shows as professor_id
    @JsonProperty("professorEntity")
    ProfessorEntity professorEntity;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @JsonProperty("subjectEntity")
    SubjectEntity subjectEntity;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "admission_id")
    @JsonProperty("admissionRecord")
    AdmissionRecord admissionRecord;
}
