package questLog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import questLog.entities.Contact;
import questLog.services.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    ContactService contactService;

    //Create

    @GetMapping
    public ResponseEntity<?> getContact() {
        return ResponseEntity.ok(contactService.findAll());
    }

    //Read
    @GetMapping("{contactId}")
    public ResponseEntity<?> getContactById(@PathVariable Long contactId) {
        return ResponseEntity.ok(contactService.findById(contactId));
    }

    @PostMapping
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.save(contact));
    }
    //Update
    @PutMapping("{contactId}")
    public ResponseEntity<?> updateContact(@PathVariable Long contactId, @RequestBody Contact updatedContact) {
        return ResponseEntity.ok(contactService.update(contactId, updatedContact));
    }
    //Delete
    @DeleteMapping("{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable Long contactId) {
        return contactService.delete(contactId);
    }
}
