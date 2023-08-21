package questLog.entities.attachables;

import javax.persistence.*;

@Entity
public class RoadMarker extends Attachable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private ImageAttachable reward;
}
