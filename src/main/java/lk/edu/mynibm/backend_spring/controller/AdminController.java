package lk.edu.mynibm.backend_spring.controller;

import lk.edu.mynibm.backend_spring.dto.AdminDTO;
import lk.edu.mynibm.backend_spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getadmins")
    public List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/getadmin/{Id}")
    public AdminDTO getAdminById(@PathVariable int Id) {
        return adminService.getAdminById(Id);
    }

    @PostMapping("/saveadmin")
    public AdminDTO saveAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.saveAdmin(adminDTO);
    }

    @PutMapping("/updateadmin")
    public AdminDTO updateAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(adminDTO);
    }

    @DeleteMapping("/deleteadmin")
    public String deleteAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.deleteAdmin(adminDTO);
    }

    @DeleteMapping("/deleteadmin/{Id}")
    public String deleteAdminById(@PathVariable Integer Id) {
        return adminService.deleteAdminById(Id);
    }
}
