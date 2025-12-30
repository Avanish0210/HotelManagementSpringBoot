package CollegeManagement.CollegeManagement.controller;

import CollegeManagement.CollegeManagement.Dto.AdmissionRecordDto;
import CollegeManagement.CollegeManagement.Entity.AdmissionRecord;
import CollegeManagement.CollegeManagement.service.AdmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admission")
public class AdmissionController {
    public AdmissionService admissionService;
    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @GetMapping
    public List<AdmissionRecordDto> GetAdmissionRecords(){
        return admissionService.GetAdmissionRecords();

    }

    @PostMapping
    public AdmissionRecordDto addAdmissionRecord(@RequestBody AdmissionRecord admissionRecord){
        return admissionService.addAdmissionRecord(admissionRecord);
    }

    @PutMapping("/{admissionId}")
    public AdmissionRecordDto updateAdmission(@RequestBody AdmissionRecord admissionRecord, @PathVariable(name = "admissionId") Long admissionId){
        return admissionService.updateAdmission(admissionRecord , admissionId);
    }

    @DeleteMapping("/{admissionId}")
    public boolean deleteAdmission(@PathVariable(name = "admissionId") Long admissionId){
        return admissionService.deleteAdmission(admissionId);
    }
}
