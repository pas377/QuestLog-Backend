package questLog.entities.quests;

import questLog.entities.attachables.RoadMarker;

import javax.persistence.*;
@Entity
public class MainQuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id; // Identifier field for subclasses to inherit
    @Column(name = "name")
    private String name;
    @Column(name = "destination")
    private String destination;

    @OneToOne
    private RoadMarker marker1;
    @OneToOne
    private RoadMarker marker2;
    @OneToOne
    private RoadMarker marker3;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public RoadMarker getMarker1() {
        return marker1;
    }

    public void setMarker1(RoadMarker marker1) {
        this.marker1 = marker1;
    }

    public RoadMarker getMarker2() {
        return marker2;
    }

    public void setMarker2(RoadMarker marker2) {
        this.marker2 = marker2;
    }

    public RoadMarker getMarker3() {
        return marker3;
    }

    public void setMarker3(RoadMarker marker3) {
        this.marker3 = marker3;
    }
}
