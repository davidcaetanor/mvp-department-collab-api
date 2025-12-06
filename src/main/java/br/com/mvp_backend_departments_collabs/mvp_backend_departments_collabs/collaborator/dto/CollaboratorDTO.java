package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.dto;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.model.DepartmentModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CollaboratorDTO(UUID idCollaborator,
                              String nameCollaborator,
                              String cpfCollaborator,
                              BigDecimal salaryCollaborator,
                              LocalDate dateBirthCollaborator,
                              DepartmentModel departmentModel) {
}
