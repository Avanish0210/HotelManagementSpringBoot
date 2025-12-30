package CollegeManagement.CollegeManagement.Repository;

import CollegeManagement.CollegeManagement.Entity.AdmissionRecord;
import CollegeManagement.CollegeManagement.service.AdmissionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<AdmissionRecord,Long> {
}
