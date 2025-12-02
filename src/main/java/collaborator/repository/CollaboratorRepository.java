package collaborator.repository;

import collaborator.model.CollaboratorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CollaboratorRepository extends JpaRepository<CollaboratorModel, UUID> {
}
