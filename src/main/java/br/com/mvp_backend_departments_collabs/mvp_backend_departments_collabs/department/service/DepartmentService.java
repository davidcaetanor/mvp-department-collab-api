package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.service;


import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.model.CollaboratorModel;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.repository.CollaboratorRepository;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.dto.DepartmentDTO;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.dto.DepartmentDTOWITHCollabs;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.mapper.DepartmentMapper;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.model.DepartmentModel;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.repository.DepartmentRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service

public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;
    private CollaboratorRepository collaboratorRepository;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper, CollaboratorRepository collaboratorRepository) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.collaboratorRepository = collaboratorRepository;
    }

    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentModel> models = departmentRepository.findAll();
        return models.stream()
                .map(departmentMapper::mapToDTO)
                .toList();
    }

    public DepartmentDTO saveDepartment(DepartmentDTO dto) {
        DepartmentModel model;
        model = departmentMapper.mapToModel(dto);
        departmentRepository.save(model);
        return departmentMapper.mapToDTO(model);
    }

    public Optional<DepartmentDTOWITHCollabs> getDepartmentById(UUID id) {
        Optional<DepartmentModel> modelOptional = departmentRepository.findById(id);
        return modelOptional.map(departmentMapper::mapToDTOWithCollabs);
    }

    @Transactional
    public void addManager(UUID departmentID, Map<String, Object> managerID) {
        DepartmentModel departmentFound = departmentRepository.findById(departmentID)
                .orElseThrow(() -> new IllegalArgumentException("Department not Found"));

        List<String> keys = List.of("departmentmanagerid", "departmentManagerId",
                "departmentmanager", "departmentManagerID");

        String raw = keys.stream()
                .filter(managerID::containsKey)
                .findFirst()
                .map(k -> managerID.get(k).toString())
                .orElseThrow(() -> new IllegalArgumentException("The key departmentManagerId was not found"));

        UUID managerUuid;

        try {
            managerUuid = UUID.fromString(raw);
        } catch (Exception e) {
            throw new IllegalArgumentException("Uuid invalid");
        }

        CollaboratorModel collaboratorModel = collaboratorRepository.findById(managerUuid)
                .orElseThrow(() -> new IllegalArgumentException("Collaborator not Found"));

        if (collaboratorModel.getDepartment() == null || collaboratorModel.getDepartment().getIdDepartment() == null
            || !collaboratorModel.getDepartment().getIdDepartment().equals(departmentID)){
                throw new IllegalArgumentException("The collaborator not affiliated with the department");
        }

        Optional<DepartmentModel> other = departmentRepository.findByDepartmentManager(collaboratorModel);
        if (other.isPresent() && !other.get().getIdDepartment().equals(departmentID)){
            throw new IllegalArgumentException("Collaborator is a manager from another department");
        }

        departmentFound.setDepartmentManager(collaboratorModel);
        departmentRepository.save(departmentFound);
    }

    public void deleteDepartment(UUID id){
        departmentRepository.deleteById(id);
    }
}