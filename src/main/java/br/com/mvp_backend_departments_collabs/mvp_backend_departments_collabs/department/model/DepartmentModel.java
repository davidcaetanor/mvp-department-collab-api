package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.model;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.model.CollaboratorModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_department")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idDepartment;

    @Column(name = "name_department")
    private String nameDepartment;

    @Column(name = "room_number_department")
    private int roomNumberDepartment;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", unique = true)
    private CollaboratorModel departmentManager;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<CollaboratorModel> departmentCollaborators =  new ArrayList<>();
}
