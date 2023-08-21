package questLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import questLog.entities.User;
import questLog.entities.attachables.AutoSummary;
import questLog.entities.quests.MainQuest;
import questLog.menus.MainMenu;
import questLog.repositories.UserRepository;

import java.util.Scanner;

@SpringBootApplication
public class QuestLogApplication {

	// ANSI escape code for golden color
	private static final String ANSI_GOLD = "\u001B[33m";
	// ANSI escape code to reset to default color
	private static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QuestLogApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		Scanner scanner = new Scanner(System.in);

		System.out.print(ANSI_GOLD + "Welcome adventurer, enter your username: " + ANSI_RESET);
		String userName = scanner.nextLine().trim().toLowerCase();

		// Find the user by ID
		User user = userRepository.findByName(userName).orElse(null);

		if (user != null) {

			System.out.println(ANSI_GOLD + "Welcome " + user.getName() + "!" + ANSI_RESET);
			// Instantiate the main menu and display the options
			MainMenu mainMenu = new MainMenu();
			System.out.print(ANSI_GOLD);
			mainMenu.displayMenuOptions();
			System.out.print(ANSI_RESET);

		} else {
			System.out.println(ANSI_GOLD + "Ah, a new adventurer! Welcome " + userName +
					", tell us, what is the purpose of quest?: " + ANSI_RESET);
			String statedPurpose = scanner.nextLine();
			System.out.print(ANSI_GOLD + "Name this Quest: " + ANSI_RESET);
			String questName = scanner.nextLine();

			// Create a new user and associate autoSummary and mainQuest with it

			User newUser = new User();
			newUser.setName(userName);

			AutoSummary autoSummary = new AutoSummary();
			autoSummary.setStatedPurpose(statedPurpose);
			newUser.setSummary(autoSummary);

			MainQuest mainQuest = new MainQuest();
			mainQuest.setName(questName);
			mainQuest.setDestination(statedPurpose);
			newUser.addMainQuest(mainQuest);

			// Save the new user to the database
			userRepository.save(newUser);
		}
		MainMenu mainMenu = new MainMenu();
		System.out.print(ANSI_GOLD);
		mainMenu.displayMenuOptions();
		System.out.print(ANSI_RESET);

		scanner.close();

	}
}
