package lk.edu.mynibm.backend_spring.service;

import lk.edu.mynibm.backend_spring.dto.AnnouncementRequestDTO;
import lk.edu.mynibm.backend_spring.dto.AnnouncementResponseDTO;
import lk.edu.mynibm.backend_spring.model.Announcement;
import lk.edu.mynibm.backend_spring.repo.AnnouncementRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnnouncementService {

    @Autowired
    private AnnouncementRepo announcementRepo;

    @Autowired
    @Qualifier("customModelMapper")
    private ModelMapper modelMapper;

    public AnnouncementResponseDTO saveAnnouncement(AnnouncementRequestDTO announcementRequestDTO) {

        Announcement announcement = modelMapper.map(announcementRequestDTO, Announcement.class);
        Announcement savedAnnouncement = announcementRepo.save(announcement);
        return modelMapper.map(savedAnnouncement, AnnouncementResponseDTO.class);
    }

//    public AnnouncementResponseDTO getAnnouncementById(Integer teacherID) {
//        Announcement announcement = announcementRepo.findAnnouncementById(teacherID)
//                .orElseThrow(() -> new RuntimeException("Announcement with ID " + teacherID + " not found"));
//
//        return modelMapper.map(announcement, AnnouncementResponseDTO.class);
//    }

    public List<AnnouncementResponseDTO> getAnnouncementsByTeacher(Integer teacherID) {

        List<Announcement> announcements = announcementRepo.findByTeacherID(teacherID);

        if (announcements.isEmpty()) {
            throw new RuntimeException("No announcements found for Teacher ID " + teacherID);
        }

        return announcements.stream()
                .map(announcement -> modelMapper.map(announcement, AnnouncementResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<AnnouncementResponseDTO> getAnnouncementsForStudents(Integer studentID) {

        List<Announcement> announcements = announcementRepo.findByStudentIDsContaining(studentID);

        if (announcements.isEmpty()) {
            throw new RuntimeException("No announcements found for Student ID " + studentID);
        }

        return announcements.stream()
                .map(announcement -> modelMapper.map(announcement, AnnouncementResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<AnnouncementResponseDTO> getAnnouncementsForBatch(Integer batchID) {

        List<Announcement> announcements = announcementRepo.findByBatchIDsContaining(batchID);

        if (announcements.isEmpty()) {
            throw new RuntimeException("No announcements found for Batch ID " + batchID);
        }

        return announcements.stream()
                .map(announcement -> modelMapper.map(announcement, AnnouncementResponseDTO.class))
                .collect(Collectors.toList());
    }


    public AnnouncementResponseDTO updateAnnouncement(Integer id, AnnouncementRequestDTO announcementRequestDTO) {

        Announcement announcement = announcementRepo.findAnnouncementById(id)
                .orElseThrow(() -> new RuntimeException("Announcement with ID " + id + " not found"));

        modelMapper.map(announcementRequestDTO, announcement);
        Announcement updatedAnnouncement = announcementRepo.save(announcement);

        return modelMapper.map(updatedAnnouncement, AnnouncementResponseDTO.class);
    }
}
