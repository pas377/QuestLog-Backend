package questLog.entities;

import questLog.entities.attachables.AutoSummary;
import questLog.entities.attachables.ImageAttachable;
import questLog.entities.quests.MainQuest;
import questLog.entities.quests.SideQuest;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL) // Add CascadeType.ALL or the appropriate cascade type
    private MainQuest mainQuest;
    @OneToMany
    private List<SideQuest> sideQuests;
    @OneToMany
    private List<ImageAttachable> inventory;
    @OneToOne(cascade = CascadeType.ALL) // Add CascadeType.ALL or the appropriate cascade type
    private AutoSummary summary;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImageAttachable> getInventory() {
        return inventory;
    }
    public boolean addToInventory(ImageAttachable item) {
        // Assuming ImageObject has a 'name' property
        Long id = item.getId();

        for (ImageAttachable currentItem : inventory) {
            if (currentItem.getId().equals(id)) {
                return false; // Item with the same name already exists in the inventory
            }
        }

        inventory.add(item);
        return true; // Item added successfully
    }
    public boolean removeFromInventory(Long id) {
        ImageAttachable foundItem = null;
        for (ImageAttachable item : inventory) {
            if (item.getId().equals(id)) {
                foundItem = item;
                break;
            }
        }

        if (foundItem != null) {
            inventory.remove(foundItem);
            return true; // Item removed successfully
        }

        return false; // Item not found in the inventory
    }

    public MainQuest getMainQuest() {
        return mainQuest;
    }

    public boolean addMainQuest(MainQuest quest) {
        if (mainQuest != null) {
            return false; // User already has a main quest, cannot add another one
        }

        // Create a new MainQuest entity and set its name
        MainQuest newMainQuest = new MainQuest();

        // Set the new MainQuest as the user's main quest
        mainQuest = newMainQuest;

        return true; // MainQuest set successfully
    }
    public void removeMainQuest() {
        mainQuest = null; // Remove the current MainQuest
    }

    public boolean addSideQuest(SideQuest sideQuest) {
        // Assuming SideQuest has a 'name' property
        String name = sideQuest.getName();

        for (SideQuest currentQuest : sideQuests) {
            if (currentQuest.getName().equals(name)) {
                return false; // Quest with the same name already exists in the list
            }
        }

        sideQuests.add(sideQuest);
        return true; // Quest added successfully
    }
    public boolean removeSideQuest(String name) {
        SideQuest foundQuest = null;
        for (SideQuest quest : sideQuests) {
            if (quest.getName().equals(name)) {
                foundQuest = quest;
                break;
            }
        }

        if (foundQuest != null) {
            sideQuests.remove(foundQuest);
            return true; // Quest removed successfully
        }

        return false; // Quest not found in the list
    }
    public AutoSummary getSummary() {
        return summary;
    }
    public void setSummary(AutoSummary summary) {
        this.summary = summary;
    }
}
