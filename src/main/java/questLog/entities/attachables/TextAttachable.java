package questLog.entities.attachables;

import javax.persistence.*;

@Entity
public class TextAttachable extends Attachable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private Type type;
    public enum Type {
        PRAYER,
        JOURNAL_ENTRY
        // Add more types as needed
    }
    public TextAttachable(Long id, Type type) {
        super(); // Call the default constructor of the parent class (Attachable)
        this.id = id;
        this.type = type;
        setImage(null); // Set the image to null
    }
}
