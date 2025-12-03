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
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private BigDecimal salary;

    @Column(nullable = false)
    private LocalDate dateBirth;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel departmentModel;

}
