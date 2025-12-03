package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.repository;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.department.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, UUID> {
}
