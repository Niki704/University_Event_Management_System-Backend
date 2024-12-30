package lk.edu.mynibm.backend_spring.service;

import lk.edu.mynibm.backend_spring.dto.AdminDTO;
import lk.edu.mynibm.backend_spring.model.Admin;
import lk.edu.mynibm.backend_spring.repo.AdminRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<AdminDTO> getAllAdmins() {
        List<Admin>adminList = adminRepo.findAll();
        return modelMapper.map(adminList, new TypeToken<List<AdminDTO>>() {}.getType());
    }

    public AdminDTO getAdminById(Integer Id) {
        Admin admin = adminRepo.findAdminById(Id);
        return modelMapper.map(admin, AdminDTO.class);
    }

    public AdminDTO saveAdmin(AdminDTO adminDTO) {
        adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        return adminDTO;
    }

    public AdminDTO updateAdmin(AdminDTO adminDTO) {
        adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        return adminDTO;
    }

    public String deleteAdmin(AdminDTO adminDTO) {
        adminRepo.delete(modelMapper.map(adminDTO, Admin.class));
        return "Admin deleted";
    }

    public String deleteAdminById(Integer Id) {
        adminRepo.deleteById(Id);
        return "Admin deleted by ID";
    }
}
