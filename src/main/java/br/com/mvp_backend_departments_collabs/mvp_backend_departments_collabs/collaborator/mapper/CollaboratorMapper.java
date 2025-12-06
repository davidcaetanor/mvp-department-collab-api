package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.mapper;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.dto.CollaboratorDTO;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.model.CollaboratorModel;
import org.springframework.stereotype.Component;

@Component
public class CollaboratorMapper {

    public CollaboratorModel mapToModel(CollaboratorDTO dto) {
        CollaboratorModel model = new CollaboratorModel();
        model.setIdCollaborator(dto.idCollaborator());
        model.setNameCollaborator(dto.nameCollaborator());
        model.setCpfCollaborator(dto.cpfCollaborator());
        model.setSalaryCollaborator(dto.salaryCollaborator());
        model.setDateBirthCollaborator(dto.dateBirthCollaborator());
        model.setDepartment(dto.departmentModel());
        return model;
    }

    public CollaboratorDTO mapToDTO(CollaboratorModel model) {
        return new CollaboratorDTO(model.getIdCollaborator(), model.getNameCollaborator(),
                model.getCpfCollaborator(), model.getSalaryCollaborator(),
                model.getDateBirthCollaborator(), model.getDepartment());
    }


}
