package questLog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import questLog.entities.quests.MainQuest;
import questLog.services.QuestService;

@RestController
@RequestMapping("/quests")
public class QuestController {
    @Autowired
    QuestService questService;

    //CREATE
    @GetMapping
    public ResponseEntity<?> getEntity() {
        return ResponseEntity.ok(questService.findAll());
    }

    //READ
    @GetMapping("{questId}")
    public ResponseEntity<?> getEntityById(@PathVariable Long questId) {
        return ResponseEntity.ok(questService.findById(questId));
    }
    @PostMapping
    public ResponseEntity<?> createEntity(@RequestBody MainQuest quest) {
        return ResponseEntity.ok(questService.save(quest));
    }

    //UPDATE
    @PutMapping("{questId}")
    public ResponseEntity<?> updateEntity(@PathVariable Long questId, @RequestBody MainQuest updatedQuest) {
        return ResponseEntity.ok(questService.update(questId, updatedQuest));
    }

    //DELETE
    @DeleteMapping("{questId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long questId) {
        return questService.delete(questId);
    }
}
