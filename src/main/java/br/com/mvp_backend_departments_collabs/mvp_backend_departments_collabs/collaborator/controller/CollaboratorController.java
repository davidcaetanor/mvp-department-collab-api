package br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.controller;

import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.dto.CollaboratorDTO;
import br.com.mvp_backend_departments_collabs.mvp_backend_departments_collabs.collaborator.service.CollaboratorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("collaborators")
public class CollaboratorController {

    private CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @GetMapping
    public List<CollaboratorDTO> collaboratorFindALL(){
        return collaboratorService.getALLCollaborator();
    }

    @PostMapping
    public CollaboratorDTO collaboratorSave(@RequestBody CollaboratorDTO dto){
        return collaboratorService.saveCollaborator(dto);
    }

    @PutMapping("{id}")
    public Optional<CollaboratorDTO> collaboratorUpdate(@PathVariable UUID id, @RequestBody CollaboratorDTO dto){
        return collaboratorService.updateCollaborator(id, dto);
    }

    @GetMapping("{id}")
    public Optional<CollaboratorDTO> collaboratorFindById(@PathVariable UUID id){
        return collaboratorService.getCollaboratorByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCollaborator(@PathVariable UUID id){
        collaboratorService.deleteCollaborator(id);
    }

}
