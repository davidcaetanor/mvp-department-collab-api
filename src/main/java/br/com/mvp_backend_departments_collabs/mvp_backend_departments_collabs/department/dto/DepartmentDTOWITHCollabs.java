package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.dto;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.model.CollaboratorModel;

import java.util.List;
import java.util.UUID;

public record DepartmentDTOWITHCollabs(UUID idDepartment, String nameDepartment, int roomNumberDepartment,
                                       CollaboratorModel departmentManager,
                                       List<CollaboratorModel> departmentCollaborators) {
}
