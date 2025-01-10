package lk.edu.mynibm.backend_spring.service;

import lk.edu.mynibm.backend_spring.dto.LecturerDTO;
import lk.edu.mynibm.backend_spring.model.Lecturer;
import lk.edu.mynibm.backend_spring.repo.LecturerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LecturerService {

    @Autowired
    private LecturerRepo lecturerRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<LecturerDTO> getAllLecturers() {
        List<Lecturer>lecturerList = lecturerRepo.findAll();
        return modelMapper.map(lecturerList, new TypeToken<List<LecturerDTO>>() {}.getType());
    }

    public LecturerDTO getLecturerById(Integer Id) {
        Lecturer lecturer = lecturerRepo.findLecturerById(Id);
        return modelMapper.map(lecturer, LecturerDTO.class);
    }

    public String saveLecturer(LecturerDTO lecturerDTO) {
        lecturerRepo.save(modelMapper.map(lecturerDTO, Lecturer.class));
        return "Lecturer Created Successfully!";
    }

    public List<Lecturer> addBulkLecturers(List<Lecturer> lecturers) {
        return lecturerRepo.saveAll(lecturers);
    }

    public String updateLecturer(Integer id, LecturerDTO lecturerDTO) {
        Lecturer lecturer = lecturerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer with ID " + id + " not found"));

        modelMapper.map(lecturerDTO, lecturer);
        lecturerRepo.save(lecturer);
        return "Lecturer Updated Successfully!";
    }

    public String deleteLecturerById(Integer id) {
        lecturerRepo.deleteById(id);
        return "Lecturer Deleted Successfully!";
    }
}
