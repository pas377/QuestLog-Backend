package questLog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import questLog.entities.quests.MainQuest;

import java.util.Optional;

@Repository
public interface QuestRepository extends JpaRepository<MainQuest, Long> {
    Optional<MainQuest> findById(Long id);
}
