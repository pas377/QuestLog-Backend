package questLog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questLog.entities.Contact;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findTheContactByFirstName(String firstName);
    Optional<Contact> findTheContactByLastName(String lastName);
    Optional<Contact> findTheContactByEmail(String email);
}
