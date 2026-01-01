package CollegeManagement.CollegeManagement.service;

import CollegeManagement.CollegeManagement.Dto.StudentDto;
import CollegeManagement.CollegeManagement.Entity.ProfessorEntity;
import CollegeManagement.CollegeManagement.Entity.StudentEntity;
import CollegeManagement.CollegeManagement.Entity.SubjectEntity;
import CollegeManagement.CollegeManagement.Repository.ProfessorRepository;
import CollegeManagement.CollegeManagement.Repository.StudentRepository;
import CollegeManagement.CollegeManagement.Repository.SubjectRepository;
import CollegeManagement.CollegeManagement.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    public ProfessorRepository professorRepository;
    public SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;
    public StudentService(StudentRepository studentRepository, ProfessorRepository professorRepository,SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.studentRepository=studentRepository;
        this.modelMapper=modelMapper;
        this.professorRepository=professorRepository;
        this.subjectRepository=subjectRepository;
    }

    public StudentDto GetStudentById(Long studentId) {
        log.info("StudentController:GetStudentById");
        StudentEntity getStudentId = studentRepository.findStudentByIdWithOneQuery(studentId);
        return modelMapper.map(getStudentId, StudentDto.class);
    }
    //get Students(Get)
    public List<StudentDto> getStudents() {
        log.info("StudentController:getStudents");
        List<StudentEntity> studentEntityList = studentRepository.getStudentsOptimized();
        return studentEntityList
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    //post Students(Post)
    public StudentDto createStudent(StudentDto newStudentDto) {
        log.info("StudentController:createStudent");
        //StudentEntity studentEntity = modelMapper.map(newStudentDto , StudentEntity.class);
        //StudentEntity saveStudent = studentRepository.save(studentEntity);
        //return modelMapper.map(saveStudent, StudentDto.class);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(newStudentDto.getName());

        ProfessorEntity professorEntity = professorRepository.findById(newStudentDto.getProfessor().getId()).orElseThrow(() -> new RuntimeException("professor not found"));
        SubjectEntity subjectEntity = subjectRepository.findById(newStudentDto.getSubject().getId()).orElseThrow(() -> new RuntimeException("subject not found"));


        studentEntity.setProfessorEntity(professorEntity);
        studentEntity.setSubjectEntity(subjectEntity);

        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);
        return modelMapper.map(savedStudentEntity, StudentDto.class);
    }

    //update Student(Put)
    public StudentDto updateStudent(StudentDto updateStudentDto, Long studentId) {
        log.info("StudentController:updateStudent");
        StudentEntity existingStudent = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        modelMapper.map(updateStudentDto , existingStudent);
        existingStudent.setId(studentId);
        StudentEntity saveStudent = studentRepository.save(existingStudent);
        return modelMapper.map(saveStudent , StudentDto.class);
    }


    //delete Students(Delete)
    public void isExist(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist) throw  new ResourceNotFoundException("Student with id: " + studentId + " not found");

    }
    public boolean deleteStudent(Long studentId) {
        log.info("StudentController:deleteStudent");
        isExist(studentId);
        studentRepository.deleteById(studentId);
        return true;
    }



    //patch operation


}
