package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.controller;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.dto.DepartmentDTO;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartment();
    }

    @PostMapping
    public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO dto){
        return departmentService.saveDepartment(dto);
    }
}
