package CollegeManagement.CollegeManagement.controller;

import CollegeManagement.CollegeManagement.Dto.SubjectDto;
import CollegeManagement.CollegeManagement.Repository.SubjectRepository;
import CollegeManagement.CollegeManagement.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    public SubjectService subjectService;
    public  SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping("/{subjectId}")
    public SubjectDto GetSubjectById(@PathVariable(name = "subjectId") Long subjectId){
        return subjectService.GetSubjectById(subjectId);
    }

    @GetMapping
    public List<SubjectDto> subjectList(){
        return subjectService.subjectList();
    }

    @PostMapping
    public SubjectDto addSubject(@RequestBody SubjectDto addSubjectDto){
        return subjectService.addSubject(addSubjectDto);
    }

    @PutMapping("/{subjectId}")
    public SubjectDto updateSubject(@RequestBody SubjectDto updateSubjectDto , @PathVariable(name = "subjectId") Long subjectId){
        return subjectService.updateSubject(updateSubjectDto , subjectId);
    }

    @DeleteMapping("/{subjectId}")
    public boolean deleteSubject(@PathVariable(name = "subjectId") Long subjectId){
        return subjectService.deleteSubject(subjectId);
    }
}
