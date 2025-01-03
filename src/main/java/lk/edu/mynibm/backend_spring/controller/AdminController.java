package lk.edu.mynibm.backend_spring.controller;

import lk.edu.mynibm.backend_spring.dto.AdminDTO;
import lk.edu.mynibm.backend_spring.model.Admin;
import lk.edu.mynibm.backend_spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class AdminController {

    @Autowired
    private AdminService adminService;

//    @GetMapping("/getadmins")
//    public List<AdminDTO> getAllAdmins() {
//        return adminService.getAllAdmins();
//    }

//    @GetMapping("/getadmin/{Id}")
//    public AdminDTO getAdminById(@PathVariable int Id) {
//        return adminService.getAdminById(Id);
//    }

    @PostMapping("/admins/add")
    public String saveAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.saveAdmin(adminDTO);
    }

    @PostMapping("/admins/bulk")
    public ResponseEntity<List<Admin>> addBulk(@RequestBody List<Admin> admins) {
        List<Admin> savedAdmins = adminService.addBulkAdmins(admins);
        return ResponseEntity.ok(savedAdmins);
    }

    @PutMapping("/admins/update/{id}")
    public String updateAdmin(@PathVariable Integer id, @RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(id, adminDTO);
    }

//    @DeleteMapping("/deleteadmin")
//    public String deleteAdmin(@RequestBody AdminDTO adminDTO) {
//        return adminService.deleteAdmin(adminDTO);
//    }

    @DeleteMapping("/admins/delete/{id}")
    public String deleteAdminById(@PathVariable Integer id) {
        return adminService.deleteAdminById(id);
    }
}
