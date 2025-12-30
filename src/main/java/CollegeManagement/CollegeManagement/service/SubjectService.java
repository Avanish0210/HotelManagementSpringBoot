package CollegeManagement.CollegeManagement.service;

import CollegeManagement.CollegeManagement.Dto.SubjectDto;
import CollegeManagement.CollegeManagement.Entity.SubjectEntity;
import CollegeManagement.CollegeManagement.Repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    public SubjectRepository subjectRepository;
    public ModelMapper modelMapper;
    public SubjectService(SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
    }

    public SubjectDto GetSubjectById(Long subjectId) {
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(() -> new RuntimeException("subject not found"));
        return modelMapper.map(subjectEntity, SubjectDto.class);
    }

    public List<SubjectDto> subjectList() {
        List<SubjectEntity> subjectList = subjectRepository.findAll();
        return subjectList
                .stream()
                .map(subject -> modelMapper.map(subject, SubjectDto.class) )
                .collect(Collectors.toList());
    }

    public SubjectDto addSubject(SubjectDto addSubjectDto) {
        SubjectEntity subjectEntity = modelMapper.map(addSubjectDto, SubjectEntity.class);
        subjectRepository.save(subjectEntity);
        return modelMapper.map(subjectEntity, SubjectDto.class);
    }

    public SubjectDto updateSubject(SubjectDto updateSubjectDto, Long subjectId) {
        SubjectEntity existingSubject = subjectRepository.findById(subjectId).orElseThrow(() -> new RuntimeException("subject not found"));
        modelMapper.map(updateSubjectDto, existingSubject);
        existingSubject.setId(subjectId);
        SubjectEntity saveSubject = subjectRepository.save(existingSubject);
        return modelMapper.map(saveSubject, SubjectDto.class);
    }

    public void isExist(Long subjectId) {
        boolean exist = subjectRepository.existsById(subjectId);
        if (!exist) {
            throw new RuntimeException("subject not found");
        }
    }
    public boolean deleteSubject(Long subjectId) {
        isExist(subjectId);
        subjectRepository.deleteById(subjectId);
        return true;
    }

}
