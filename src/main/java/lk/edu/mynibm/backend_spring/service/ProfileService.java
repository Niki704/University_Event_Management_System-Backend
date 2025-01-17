package lk.edu.mynibm.backend_spring.service;

import lk.edu.mynibm.backend_spring.dto.ProfileDTO;
import lk.edu.mynibm.backend_spring.model.Profile;
import lk.edu.mynibm.backend_spring.repo.ProfileRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ProfileDTO getProfileById(Integer userID) {
        Profile profile = profileRepo.findProfileById(userID)
                .orElseThrow(() -> new RuntimeException("Profile with ID " + userID + " not found"));
        return modelMapper.map(profile, ProfileDTO.class);
    }

    public void saveProfile(ProfileDTO profileDTO) {
        Profile profile = modelMapper.map(profileDTO, Profile.class);
        profileRepo.save(profile);
    }

    public List<Profile> addBulkProfiles(List<Profile> profiles) {
        return profileRepo.saveAll(profiles);
    }

    public void updateProfile(Integer userID, ProfileDTO profileDTO) {
        Profile profile = profileRepo.findById(userID)
                .orElseThrow(() -> new RuntimeException("Profile with ID " + userID + " not found"));

        modelMapper.map(profileDTO, profile);
        profileRepo.save(profile);
    }

    // Delete profile by user ID
//    public void deleteProfileById(Integer userID) {
//        profileRepo.deleteById(userID);
//    }
}
