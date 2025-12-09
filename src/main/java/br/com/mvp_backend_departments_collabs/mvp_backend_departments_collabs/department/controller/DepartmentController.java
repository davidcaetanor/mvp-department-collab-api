package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.controller;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.dto.DepartmentDTO;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.dto.DepartmentDTOWITHCollabs;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


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

    @GetMapping("{id}")
    public Optional<DepartmentDTOWITHCollabs> getDepartmentById(@PathVariable UUID id){
        return departmentService.getDepartmentById(id);
    }

    @PatchMapping("{id}/manager")
    public void addManager(@PathVariable UUID id, @RequestBody Map<String, Object> body){
        departmentService.addManager(id, body);
    }

    @DeleteMapping("{id}")
    public void deleteDepartment(@PathVariable UUID id){
        departmentService.deleteDepartment(id);
    }

}
