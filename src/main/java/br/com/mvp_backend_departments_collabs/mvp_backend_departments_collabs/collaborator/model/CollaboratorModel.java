package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.model;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.model.DepartmentModel;
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
    private UUID idCollaborator;

    @Column(name = "name_collaborator", nullable = false)
    private String nameCollaborator;

    @Column(name = "cpf_collaborator", nullable = false, unique = true)
    private String cpfCollaborator;

    @Column(name = "salary_collaborator", nullable = false)
    private BigDecimal salaryCollaborator;

    @Column(name = "date_birth_collaborator", nullable = false)
    private LocalDate dateBirthCollaborator;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;

}
