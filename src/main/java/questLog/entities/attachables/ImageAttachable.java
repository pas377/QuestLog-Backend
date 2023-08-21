package questLog.entities.attachables;

import javax.persistence.*;

@Entity
public class ImageAttachable extends Attachable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private Type type;

    public enum Type {
        ITEM, SPELL
    }

    public Long getId() {
        return id;
    }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
