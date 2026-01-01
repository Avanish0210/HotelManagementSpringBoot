package CollegeManagement.CollegeManagement.controller;

import CollegeManagement.CollegeManagement.Dto.StudentDto;
import CollegeManagement.CollegeManagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {

    //dependencies injection
    public StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public StudentDto GetStudentById(@PathVariable(name = "studentId") Long studentId){
        log.info("StudentController:GetStudentById");
        return studentService.GetStudentById(studentId);
    }
    @GetMapping
    public List<StudentDto> getStudents(){
        log.info("StudentController:GetStudents");
        return studentService.getStudents();
    }

    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto newStudentDto){
        log.info("StudentController:createStudent");
        return studentService.createStudent(newStudentDto);
    }

    @PutMapping(path = "/{studentId}")
    public StudentDto updateStudent(@RequestBody StudentDto updateStudentDto , @PathVariable(name = "studentId") Long studentId){
        log.info("StudentController:updateStudent");
        return studentService.updateStudent(updateStudentDto , studentId);
    }

    @DeleteMapping(path = "/{studentId}")
    public boolean deleteStudent(@PathVariable(name = "studentId") Long studentId){
        log.info("StudentController:deleteStudent");
        return studentService.deleteStudent(studentId);

    }



}
