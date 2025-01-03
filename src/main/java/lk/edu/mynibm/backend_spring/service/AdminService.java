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

    public String saveAdmin(AdminDTO adminDTO) {
        adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        return "Admin Created Successfully !";
    }

    //Bulk add
    public List<Admin> addBulkAdmins(List<Admin> admins) {
        return adminRepo.saveAll(admins);
    }

    public String updateAdmin(Integer id, AdminDTO adminDTO) {
        Admin admin = adminRepo.findById(id)
                        .orElseThrow(() -> new RuntimeException("Admin with ID " + id + " not found"));

        modelMapper.map(adminDTO, admin);
        adminRepo.save(admin);
//        Admin updatedAdmin = adminRepo.save(existingAdmin);
//        modelMapper.map(updatedAdmin, AdminDTO.class);
        return "Admin Updated Successfully !";
    }

    public String deleteAdmin(AdminDTO adminDTO) {
        adminRepo.delete(modelMapper.map(adminDTO, Admin.class));
        return "Admin deleted";
    }

    public String deleteAdminById(Integer Id) {
        adminRepo.deleteById(Id);
        return "Admin deleted Successfully !";
    }
}
