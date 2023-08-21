package questLog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import questLog.entities.User;
import questLog.entities.quests.MainQuest;
import questLog.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public User update(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).get();

        existingUser.setName(updatedUser.getName());
        existingUser.setSummary(updatedUser.getSummary());

        return userRepository.save(existingUser);
    }
    public ResponseEntity<?> delete(Long id) {
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "User not found with id" + id));
        userRepository.delete(userToDelete);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
