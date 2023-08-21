package questLog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import questLog.entities.attachables.Attachable;
import questLog.services.AttachableService;

@RestController
@RequestMapping("/attachables")
public class AttachableController {
    @Autowired
    AttachableService attachableService;

    //CREATE
    @GetMapping
    public ResponseEntity<?> getEntity() {
        return ResponseEntity.ok(attachableService.findAll());
    }

    //READ
    @GetMapping("{attachableId}")
    public ResponseEntity<?> getEntityById(@PathVariable Long attachableId) {
        return ResponseEntity.ok(attachableService.findById(attachableId));
    }
    @PostMapping
    public ResponseEntity<?> createEntity(@RequestBody Attachable attachable) {
        return ResponseEntity.ok(attachableService.save(attachable));
    }

    //UPDATE
    @PutMapping("{attachableId}")
    public ResponseEntity<?> updateEntity(@PathVariable Long attachableId, @RequestBody Attachable updatedAttachable) {
        return ResponseEntity.ok(attachableService.update(attachableId, updatedAttachable));
    }

    //DELETE
    @DeleteMapping("{attachableId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long attachableId) {
        return attachableService.delete(attachableId);
    }
}
