package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.service;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.dto.CollaboratorDTO;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.mapper.CollaboratorMapper;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.model.CollaboratorModel;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.repository.CollaboratorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CollaboratorService {
    private CollaboratorRepository collaboratorRepository;
    private CollaboratorMapper collaboratorMapper;

    public CollaboratorService(CollaboratorRepository collaboratorRepository, CollaboratorMapper collaboratorMapper) {
        this.collaboratorRepository = collaboratorRepository;
        this.collaboratorMapper = collaboratorMapper;
    }

    public CollaboratorDTO saveCollaborator(CollaboratorDTO dto){
        CollaboratorModel collabModel;
        collabModel = collaboratorMapper.mapToModel(dto);
        collaboratorRepository.save(collabModel);
        return collaboratorMapper.mapToDTO(collabModel);
    }

    public List<CollaboratorDTO> getALLCollaborator(){
        List<CollaboratorModel> models = collaboratorRepository.findAll();
        return models.stream()
                .map(collaboratorMapper::mapToDTO)
                .toList();
    }

    public Optional<CollaboratorDTO> getCollaboratorByID(UUID id){
        Optional<CollaboratorModel> modelOptional = collaboratorRepository.findById(id);
        return modelOptional.map(collaboratorMapper::mapToDTO);
    }

    public Optional<CollaboratorDTO> updateCollaborator(UUID id, CollaboratorDTO dto) {
        Optional<CollaboratorModel> collaboratorExists = collaboratorRepository.findById(id);
        Optional<CollaboratorDTO> collaboratorDTO = Optional.empty();
        if (collaboratorExists.isPresent()) {
            CollaboratorModel upCollaborator = collaboratorMapper.mapToModel(dto);
            upCollaborator.setIdCollaborator(id);
            collaboratorRepository.save(upCollaborator);
            collaboratorDTO = Optional.ofNullable(collaboratorMapper.mapToDTO(upCollaborator));
        }
        return collaboratorDTO;
    }

    public void deleteCollaborator(UUID id){
        if (collaboratorRepository.existsById(id)){
            collaboratorRepository.deleteById(id);
        }
    }
}
