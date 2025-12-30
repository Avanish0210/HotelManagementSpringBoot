package CollegeManagement.CollegeManagement.Dto;

import CollegeManagement.CollegeManagement.Entity.AdmissionRecord;
import CollegeManagement.CollegeManagement.Entity.ProfessorEntity;
import CollegeManagement.CollegeManagement.Entity.SubjectEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    private Long id;
    private String name;
    private ProfessorDto professor;
    private SubjectDto subject;
    private AdmissionRecordDto admissionRecord;
}
