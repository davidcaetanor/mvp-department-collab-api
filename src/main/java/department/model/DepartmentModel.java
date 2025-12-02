package department.model;

import collaborator.model.CollaboratorModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private UUID id;
    private String name;
    private int dpRoomNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", unique = true)
    private CollaboratorModel departmentManager;

    @OneToMany(mappedBy = "departmentModel")
    private List<CollaboratorModel> departmentCollaborators;

}
