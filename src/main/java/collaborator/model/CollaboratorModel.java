package collaborator.model;

import department.model.DepartmentModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_collaborator")

public class CollaboratorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String cpf;
    private BigDecimal salary;
    private LocalDate dateBirth;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel departmentModel;

}
