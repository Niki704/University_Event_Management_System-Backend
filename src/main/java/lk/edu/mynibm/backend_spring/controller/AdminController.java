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

    @PostMapping
    public String saveAdmin() {

    }
}
