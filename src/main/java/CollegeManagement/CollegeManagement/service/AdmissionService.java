package CollegeManagement.CollegeManagement.service;

import CollegeManagement.CollegeManagement.Dto.AdmissionRecordDto;
import CollegeManagement.CollegeManagement.Entity.AdmissionRecord;
import CollegeManagement.CollegeManagement.Repository.AdmissionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdmissionService {

    public AdmissionRepository admissionRepository;
    public ModelMapper modelMapper;
    public AdmissionService(AdmissionRepository admissionRepository , ModelMapper modelMapper) {
        this.admissionRepository = admissionRepository;
        this.modelMapper = modelMapper;
    }

    public List<AdmissionRecordDto> GetAdmissionRecords() {
        List<AdmissionRecord> admissionRecordList = admissionRepository.findAll();

        return admissionRecordList
                .stream()
                .map(Record -> modelMapper.map(Record , AdmissionRecordDto.class))
                .collect(Collectors.toList());
    }

    public AdmissionRecordDto addAdmissionRecord(AdmissionRecord admissionRecord) {
        AdmissionRecord admissionRecord1 = modelMapper.map(admissionRecord, AdmissionRecord.class);
        AdmissionRecord saveAdmissionRecord1 = admissionRepository.save(admissionRecord1);
        return modelMapper.map(saveAdmissionRecord1 , AdmissionRecordDto.class);
    }

    public AdmissionRecordDto updateAdmission(AdmissionRecord admissionRecord, Long admissionId) {
        AdmissionRecord existing = admissionRepository.findById(admissionId).orElseThrow(() -> new RuntimeException("record not found"));
        modelMapper.map(admissionRecord, existing);
        existing.setId(admissionId);
        AdmissionRecord saveAdmissionRecord = admissionRepository.save(existing);

        return modelMapper.map(saveAdmissionRecord , AdmissionRecordDto.class);

    }

    public void IsExist(Long admissionId) {
        boolean exists = admissionRepository.existsById(admissionId);
        if(!exists){
            throw new RuntimeException("Record not found");
        }
    }
    public boolean deleteAdmission(Long admissionId) {
        IsExist(admissionId);
        admissionRepository.deleteById(admissionId);
        return true;

    }
}
