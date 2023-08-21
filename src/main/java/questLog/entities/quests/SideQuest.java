package questLog.entities.quests;

import javax.persistence.*;

@Entity
public class SideQuest extends MainQuest {

    public SideQuest() {
        super();
        setMarker3(null);
    }
}
