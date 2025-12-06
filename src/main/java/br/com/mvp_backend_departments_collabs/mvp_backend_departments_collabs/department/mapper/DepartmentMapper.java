package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.mapper;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.dto.DepartmentDTO;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.model.DepartmentModel;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentModel mapToModel(DepartmentDTO dto){
        DepartmentModel model = new DepartmentModel();
        model.setIdDepartment(dto.idDepartment());
        model.setNameDepartment(dto.nameDepartment());
        model.setRoomNumberDepartment(dto.roomNumberDepartment());
        model.setDepartmentManager(dto.departmentManager());
        model.setDepartmentCollaborators(dto.departmentCollaborators());
        return model;
    }

    public DepartmentDTO mapToDTO(DepartmentModel model){
        return new DepartmentDTO(
                model.getIdDepartment(),
                model.getNameDepartment(),
                model.getRoomNumberDepartment(),
                model.getDepartmentManager(),
                model.getDepartmentCollaborators()
        );
    }
}
