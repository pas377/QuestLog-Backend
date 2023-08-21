package questLog.entities.attachables;

import javax.persistence.*;
//TODO - Move to DTO
@MappedSuperclass
public abstract class Attachable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id; // Identifier field for subclasses to inherit
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;

    public boolean attach() {
        //TODO impliment
        return false;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
