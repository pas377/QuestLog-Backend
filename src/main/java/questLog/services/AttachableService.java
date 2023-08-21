package questLog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import questLog.entities.attachables.Attachable;
import questLog.repositories.AttachableRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AttachableService {
    @Autowired
    AttachableRepository attachableRepository;
    public List<Attachable> findAll() {
        return attachableRepository.findAll();
    }
    public Optional<Attachable> findById(Long id) {
        return attachableRepository.findById(id);
    }
    public Attachable save(Attachable attachable) {
        return attachableRepository.save(attachable);
    }
    public Attachable update(Long id, Attachable updatedAttachable) {
        Attachable existingAttachable = attachableRepository.findById(id).get();

        existingAttachable.setName(updatedAttachable.getName());
        existingAttachable.setDescription(updatedAttachable.getDescription());

        return attachableRepository.save(existingAttachable);
    }
    public ResponseEntity<?> delete(Long id) {
        Attachable attachableToDelete = attachableRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Attachable not found with id" + id));
        attachableRepository.delete(attachableToDelete);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
