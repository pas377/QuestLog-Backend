package questLog.menus;

import questLog.entities.User;
import questLog.entities.quests.MainQuest;

public class MainMenu {

    public MainMenu() {
    }
    public void displayMenuOptions() {
        System.out.println("\nMain Menu Options:");
        System.out.println("1. Main Quest");
        System.out.println("2. Side Quests");
        System.out.println("3. Profile");
        System.out.println("4. Settings");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}
