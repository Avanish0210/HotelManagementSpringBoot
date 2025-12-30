package CollegeManagement.CollegeManagement.controller;

import CollegeManagement.CollegeManagement.Dto.ProfessorDto;
import CollegeManagement.CollegeManagement.Dto.StudentDto;
import CollegeManagement.CollegeManagement.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    public ProfessorService professorService;
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/{professorId}")
    public ProfessorDto getProfessorById(@PathVariable(name = "professorId") Long professorId){
        return professorService.getProfessorById(professorId);
    }
    @GetMapping
    public List<ProfessorDto> getProfessor(){
        return professorService.getProfessor();
    }

    @PostMapping
    public ProfessorDto createProfessor(@RequestBody ProfessorDto newprofessorDto){
        return professorService.createProfessor(newprofessorDto);
    }

    @PutMapping("/{professorId}")
    public ProfessorDto updateProfessor(@RequestBody ProfessorDto newprofessorDto , @PathVariable(name = "professorId") Long professorId){
        return professorService.updateProfessor(newprofessorDto , professorId);
    }

    @DeleteMapping("/{professorId}")
    public boolean deleteProfessor(@PathVariable(name = "professorId")Long professorId){
        return professorService.deleteProfessor(professorId);
    }
}
