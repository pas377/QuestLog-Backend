package questLog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import questLog.entities.quests.MainQuest;
import questLog.repositories.QuestRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuestService {
    @Autowired
    QuestRepository questRepository;
    public List<MainQuest> findAll() {
        return questRepository.findAll();
    }
    public Optional<MainQuest> findById(Long id) {
        return questRepository.findById(id);
    }
    public MainQuest save(MainQuest quest) {
        return questRepository.save(quest);
    }
    public MainQuest update(Long id, MainQuest updatedQuest) {
        MainQuest existingQuest = questRepository.findById(id).get();

        existingQuest.setName(updatedQuest.getName());
        existingQuest.setDestination(updatedQuest.getDestination());

        return questRepository.save(existingQuest);
    }
    public ResponseEntity<?> delete(Long id) {
        MainQuest questToDelete = questRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Quest not found with id" + id));
        questRepository.delete(questToDelete);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
