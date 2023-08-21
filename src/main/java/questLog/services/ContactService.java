package questLog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import questLog.entities.Contact;
import questLog.repositories.ContactRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
     return contactRepository.findAll();
    }

    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }
    public Optional<Contact> findByEmail(String email) {
        return contactRepository.findTheContactByEmail(email);
    }
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
    public Contact update(Long id, Contact updatedContact) {
        Contact existingContact = contactRepository.findById(id).get();

        existingContact.setFirstname(updatedContact.getFirstname());
        existingContact.setLastName(updatedContact.getLastName());
        existingContact.setEmail(updatedContact.getEmail());

        return contactRepository.save(existingContact);
    }

    public ResponseEntity<?> delete(Long id) {
        Contact contactToDelete = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact" +
                "not found with id" + id));
        contactRepository.delete(contactToDelete);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
