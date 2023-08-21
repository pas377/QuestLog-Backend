package questLog.entities.attachables;

import javax.persistence.*;

//TODO - part of a service
@Entity
public class AutoSummary extends Attachable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or other appropriate strategy
    private Long id;
    private String summary = "This is an AutoSummary!";

    //TODO - Stated purpose: "To Find the Holy Grail!"
    @Column(name = "statedPurpose")
    private String statedPurpose;

    public String getStatedPurpose() {
        return statedPurpose;
    }

    public void setStatedPurpose(String statedPurpose) {
        this.statedPurpose = statedPurpose;
    }
}
