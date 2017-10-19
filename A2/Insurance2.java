package A2;
import java.util.Scanner;

/**
 * to provide a menu system that allows one to add and query the objects
 * 
 * be able to move up and down through levels and keep circulating until you
 * want to quit. Yes/no (or y/n) prompts should be provided as necessary.
 * 
 */

public class Insurance2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		CarPolicy carPolicy = null;
		HomePolicy homePolicy = null;

		mainLoop: do {
			// output main menu
			System.out.println("\tThe Great Big Insurance Scam Company");
			System.out.println();
			System.out.println("a: Auto");
			System.out.println("b: Home");
			System.out.println();
			System.out.println("Select the insurance category (type q to quit):");

			input = keyboard.next();
			if (input.equalsIgnoreCase("a")) {// auto was selected
				autoPolicyLoop: do {
					System.out.println();
					System.out.println("a. Create new Auto policy");
					System.out.println("b. Display current policy");
					System.out.println("c. Update current policy");
					System.out.println();
					System.out.println("Select option (type m to return to main menu or q to quit)");

					input = keyboard.next();
					if (input.equalsIgnoreCase("a")) {// new Auto policy
						// reset carPolicy;
						carPolicy = new CarPolicy();

						autoInfoLoop: do {
							System.out.println();
							System.out.println("a. Driver's Name" + (carPolicy.getDriverName().equals("") ? "" : (": " + carPolicy.getDriverName())));
							System.out.println("b. Driver's age" + (carPolicy.getDriverAge() == 0 ? "" : (": " + carPolicy.getDriverAge())));
							System.out.println("c. Car type" + (carPolicy.getCarType().equals("") ? "" : (": " + carPolicy.getCarType())));
							System.out.println("d. Number of driving citations" + (carPolicy.getNumberOfCitations() == -1 ? "" : (": " + carPolicy.getNumberOfCitations())));
							System.out.println();
							System.out.println("Select option (type m to return to main menu, u to go up one level, or q to quit)");

							System.out.println("Please input Driver's name:");
							input = keyboard.next();
							if (input.equalsIgnoreCase("a")) {// driver's name
								System.out.println();
								System.out.println("Please input Driver's name:");
								carPolicy.setDriverName(keyboard.next());
								continue;
							} else if (input.equalsIgnoreCase("b")) {// driver's
																		// age
								do {
									System.out.println();
									System.out.println("Please input Driver's age(between 16 and 130):");
									int age = keyboard.nextInt();
									if (carPolicy.checkAge(age)) {
										carPolicy.setDriverAge(age);
										break;
									} else {
										System.out.println();
										System.out.println("Input is invalid! Age should be between 16 and 130.");
									}
								} while (true);
								continue;
							} else if (input.equalsIgnoreCase("c")) {// car's
																		// type
								do {
									System.out.println();
									System.out.println("Please input Car's type(sport, sedan or truck):");
									String carType = keyboard.next().toLowerCase();
									if (carType.equals("sport") || carType.equals("sedan") || carType.equals("truck")) {
										carPolicy.setCarType(carType);
										break;
									} else {
										System.out.println();
										System.out.println("Input is invalid! Car type should be sport, sedan or truck.");
									}
								} while (true);
								continue;
							} else if (input.equalsIgnoreCase("d")) {// number
																		// of
																		// citations
								do {
									System.out.println();
									System.out.println("Please input Number of driving citations:");
									int number = keyboard.nextInt();
									if (carPolicy.checkCitation(number)) {
										carPolicy.setNumberOfCitations(number);
										break;
									} else {
										System.out.println();
										System.out.println("Input is invalid! Number of citations should be between 0 and 100.");
									}
								} while (true);
								continue;
							} else if (input.equalsIgnoreCase("m")) {// return
																		// to
																		// main
																		// menu
								break autoPolicyLoop;
							} else if (input.equalsIgnoreCase("u")) {// go up
																		// one
																		// level
								break autoInfoLoop;
							} else if (input.equalsIgnoreCase("q")) {// quit
																		// application
								System.out.println();
								System.out.println("Do you want to exit this application? Please enter y/n:");
								input = keyboard.next();
								if (input.equalsIgnoreCase("y")) {
									System.out.println();
									System.out.println("Thank you.");
									break mainLoop;
								}
							} else {
								System.out.println();
								System.out.println("Input is invalid! Please select the option a, b, c or d.");
							}
						} while (true);
					} else if (input.equalsIgnoreCase("b")) {// display current
																// policy
						if (!(carPolicy == null)) {
							autoInfoDisplayLoop: do {
								System.out.println();
								System.out.println("a. Driver's Name: " + carPolicy.getDriverName());
								System.out.println("b. Driver's age: " + carPolicy.getDriverAge());
								System.out.println("c. Car type: " + carPolicy.getCarType());
								System.out.println("d. Number of driving citations: " + carPolicy.getNumberOfCitations());
								System.out.println();
								System.out.println("type m to return to main menu, u to go up one level, or q to quit");
								input = keyboard.next();
								if (input.equalsIgnoreCase("m")) {// return
									// to
									// main
									// menu
									break autoPolicyLoop;
								} else if (input.equalsIgnoreCase("u")) {// go
									// up
									// one
									// level
									break autoInfoDisplayLoop;
								} else if (input.equalsIgnoreCase("q")) {// quit
									// application
									System.out.println();
									System.out.println("Do you want to exit this application? Please enter y/n:");
									input = keyboard.next();
									if (input.equalsIgnoreCase("y")) {
										System.out.println();
										System.out.println("Thank you.");
										break mainLoop;
									}
								} else {
									System.out.println();
									System.out.println("Input is invalid! Display only!(type m to return to main menu, u to go up one level, or q to quit)");
								}
							} while (true);
						} else {
							System.out.println();
							System.out.println("You have not created Auto policy yet. Please create new Auto policy first.");
							continue;
						}
					} else if (input.equalsIgnoreCase("c")) {// update current
																// policy
						if (!(carPolicy == null)) {
							autoInfoUpdateLoop: do {
								System.out.println();
								System.out.println("a. Driver's Name: " + carPolicy.getDriverName());
								System.out.println("b. Driver's age: " + carPolicy.getDriverAge());
								System.out.println("c. Car type: " + carPolicy.getCarType());
								System.out.println("d. Number of driving citations: " + carPolicy.getNumberOfCitations());
								System.out.println();
								System.out.println("Select option you would like to update (type m to return to main menu, u to go up one level, or q to quit)");
								input = keyboard.next();
								if (input.equalsIgnoreCase("a")) {// driver's
																	// name
									System.out.println();
									System.out.println("Please input Driver's name:");
									carPolicy.setDriverName(keyboard.next());
									continue;
								} else if (input.equalsIgnoreCase("b")) {// driver's
																			// age
									do {
										System.out.println();
										System.out.println("Please input Driver's age(between 16 and 130):");
										int age = keyboard.nextInt();
										if (carPolicy.checkAge(age)) {
											carPolicy.setDriverAge(age);
											break;
										} else {
											System.out.println();
											System.out.println("Input is invalid! Age should between 16 and 130.");
										}
									} while (true);
									continue;
								} else if (input.equalsIgnoreCase("c")) {// car's
																			// type
									do {
										System.out.println();
										System.out.println("Please input Car's type(sport, sedan or truck):");
										String carType = keyboard.next().toLowerCase();
										if (carType.equals("sport") || carType.equals("sedan") || carType.equals("truck")) {
											carPolicy.setCarType(carType);
											break;
										} else {
											System.out.println();
											System.out.println("Input is invalid! Car type should be sport, sedan or truck.");
										}
									} while (true);
									continue;
								} else if (input.equalsIgnoreCase("d")) {// number
																			// of
																			// citations
									do {
										System.out.println();
										System.out.println("Please input Number of driving citations:");
										int number = keyboard.nextInt();
										if (carPolicy.checkCitation(number)) {
											carPolicy.setNumberOfCitations(number);
											break;
										} else {
											System.out.println();
											System.out.println("Input is invalid! Number of citations should between 0 and 100.");
										}
									} while (true);
									continue;
								} else if (input.equalsIgnoreCase("m")) {// return
																			// to
																			// main
																			// menu
									break autoPolicyLoop;
								} else if (input.equalsIgnoreCase("u")) {// go
																			// up
																			// one
																			// level
									break autoInfoUpdateLoop;
								} else if (input.equalsIgnoreCase("q")) {// quit
																			// application
									System.out.println();
									System.out.println("Do you want to exit this application? Please enter y/n:");
									input = keyboard.next();
									if (input.equalsIgnoreCase("y")) {
										System.out.println();
										System.out.println("Thank you.");
										break mainLoop;
									}
								} else {
									System.out.println();
									System.out.println("Input is invalid! Please select the option a, b, c or d.");
								}
							} while (true);
						} else {
							System.out.println();
							System.out.println("You have not created Auto policy yet. Please create new Auto policy first.");
							continue;
						}

					} else if (input.equalsIgnoreCase("m")) {
						break autoPolicyLoop;
					} else if (input.equalsIgnoreCase("q")) {
						System.out.println();
						System.out.println("Do you want to exit this application? Please enter y/n:");
						input = keyboard.next();
						if (input.equalsIgnoreCase("y")) {
							System.out.println();
							System.out.println("Thank you.");
							break mainLoop;
						}
					} else {
						System.out.println();
						System.out.println("Input is invalid! Please select the option a, b, or c.");
					}
				} while (true);

			} else if (input.equalsIgnoreCase("b")) {// home was selected
				System.out.println();
				System.out.println("a. Create new Home policy");
				System.out.println("b. Display current policy");
				System.out.println("c. Update current policy");
				System.out.println();
				System.out.println("Select option (type m to return to main menu or q to quit)");
			} else if (input.equalsIgnoreCase("q")) {// quit the application
				System.out.println();
				System.out.println("Do you want to exit this application? Please enter y/n:");
				input = keyboard.next();
				if (input.equalsIgnoreCase("y")) {
					System.out.println();
					System.out.println("Thank you.");
					break mainLoop;
				}
			} else {
				System.out.println();
				System.out.println("Input is invalid! Please select the option a or b.");
			}
		} while (true);
		keyboard.close();
	}
}
