package CollegeManagement.CollegeManagement.Repository;

import CollegeManagement.CollegeManagement.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity ,Long> {
    @Query("SELECT s FROM StudentEntity s LEFT JOIN FETCH s.admissionRecord")
    List<StudentEntity> findAllWithAdmissions();

    @Query("SELECT DISTINCT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.admissionRecord a " +
            "LEFT JOIN FETCH s.professorEntity p " +
            "LEFT JOIN FETCH s.subjectEntity sub " +
            "WHERE s.id = :id")
    StudentEntity findStudentByIdWithOneQuery(@Param("id") Long id);

    @Query("SELECT s FROM StudentEntity s " +
            "LEFT JOIN FETCH s.admissionRecord a " +
            "LEFT JOIN FETCH s.professorEntity p " +
            "LEFT JOIN FETCH s.subjectEntity sub")
    List<StudentEntity> getStudentsOptimized();


}
