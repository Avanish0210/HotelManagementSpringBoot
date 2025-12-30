package CollegeManagement.CollegeManagement.Repository;

import CollegeManagement.CollegeManagement.Entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}
