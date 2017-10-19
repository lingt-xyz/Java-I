package A2;
public class Menu {

	public Menu() {

	}

	public void mainMenu() {
		System.out.println("\tThe Great Big Insurance Scam Company");
		System.out.println();
		System.out.println("a: Auto");
		System.out.println("b: Home");
		System.out.println();
		System.out.println("Select the insurance category (type q to quit):");
	}

	public void autoPolicyMenu() {
		System.out.println("a. Create new Auto policy");
		System.out.println("b. Display current policy");
		System.out.println("c. Update current policy");
		System.out.println();
		System.out.println("Select option (type m to return to main menu or q to quit)");
	}

	public void autoInfoMenu() {
		System.out.println("a. Driver's Name");
		System.out.println("b. Driver's age");
		System.out.println("c. Car type");
		System.out.println("d. Number of driving citations");
		System.out.println();
		System.out.println("Select option (type m to return to main menu, u to go up one level, or q to quit)");
	}

	public void homePolicyMenu() {
		System.out.println("a. Create new Home policy");
		System.out.println("b. Display current policy");
		System.out.println("c. Update current policy");
		System.out.println();
		System.out.println("Select option (type m to return to main menu or q to quit)");
	}

	public void homeInfoMenu() {
		System.out.println("a. Address");
		System.out.println("b. Room count");
		System.out.println("c. Fireplace?");
		System.out.println("d. Square footage");
		System.out.println();
		System.out.println("Select option (type m to return to main menu, u to go up one level, or q to quit)");
	}

	public void exitMenu(){
		System.out.println("Do you want to exit this application? Please enter y/n:");
	}
	
	public void exitGreeting(){
		System.out.println("Thank you.");
	}
}
