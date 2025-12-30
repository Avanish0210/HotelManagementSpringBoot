package CollegeManagement.CollegeManagement.service;

import CollegeManagement.CollegeManagement.Dto.ProfessorDto;
import CollegeManagement.CollegeManagement.Entity.ProfessorEntity;
import CollegeManagement.CollegeManagement.Repository.ProfessorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    public ProfessorRepository professorRepository;
    public ModelMapper modelMapper;
    public ProfessorService(ProfessorRepository professorRepository, ModelMapper modelMapper) {
        this.professorRepository = professorRepository;
        this.modelMapper = modelMapper;
    }

    public ProfessorDto getProfessorById(Long professorId) {
        ProfessorEntity professorEntity = professorRepository.findById(professorId).orElseThrow(() -> new RuntimeException("Professor not found"));
        return modelMapper.map(professorEntity , ProfessorDto.class);
    }

    //get mapping
    public List<ProfessorDto> getProfessor() {
        List<ProfessorEntity> professorEntities = professorRepository.findAll();
        return professorEntities
                .stream()
                .map(professor -> modelMapper.map(professor , ProfessorDto.class))
                .collect(Collectors.toList());
    }

    public ProfessorDto createProfessor(ProfessorDto newprofessorDto) {
        ProfessorEntity professorEntity = modelMapper.map(newprofessorDto , ProfessorEntity.class);
        ProfessorEntity saveProfessor = professorRepository.save(professorEntity);
        return modelMapper.map(saveProfessor, ProfessorDto.class);
    }

    public ProfessorDto updateProfessor(ProfessorDto newprofessorDto, Long professorId) {
        ProfessorEntity existingProfessor = professorRepository.findById(professorId).orElseThrow(() -> new RuntimeException("Professor not found"));
        modelMapper.map(newprofessorDto,existingProfessor);
        existingProfessor.setId(professorId);
        ProfessorEntity saveProfessor = professorRepository.save(existingProfessor);
        return modelMapper.map(saveProfessor , ProfessorDto.class);
    }


    public void IsExist(Long professorId) {
        boolean exists = professorRepository.existsById(professorId);
        if(!exists){
            throw new RuntimeException("Professor not found");
        }
    }

    public boolean deleteProfessor(Long professorId) {
        IsExist(professorId);
        professorRepository.deleteById(professorId);
        return true;
    }


}
