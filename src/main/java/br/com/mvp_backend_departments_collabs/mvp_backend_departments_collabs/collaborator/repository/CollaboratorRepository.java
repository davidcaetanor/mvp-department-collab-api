package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.repository;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.model.CollaboratorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CollaboratorRepository extends JpaRepository<CollaboratorModel, UUID> {
}
