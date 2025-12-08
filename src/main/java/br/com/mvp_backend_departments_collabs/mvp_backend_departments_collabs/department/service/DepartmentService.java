package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.service;


import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.dto.DepartmentDTO;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.mapper.DepartmentMapper;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.model.DepartmentModel;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.repository.DepartmentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public List<DepartmentDTO> getAllDepartment(){
        List<DepartmentModel> models = departmentRepository.findAll();
        return models.stream()
                .map(departmentMapper::mapToDTO)
                .toList();
    }

    public DepartmentDTO saveDepartment(DepartmentDTO dto){
        DepartmentModel model;
        model = departmentMapper.mapToModel(dto);
        departmentRepository.save(model);
        return departmentMapper.mapToDTO(model);
    }

}
