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

    public AdminDTO saveAdmin(AdminDTO adminDTO) {
        adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        return adminDTO;
    }
}
