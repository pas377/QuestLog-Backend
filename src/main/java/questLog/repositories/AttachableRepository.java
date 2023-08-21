package questLog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questLog.entities.attachables.Attachable;

import java.util.Optional;

@Repository
public interface AttachableRepository extends JpaRepository<Attachable, Long> {
    Optional<Attachable> findById(Long id);
}
