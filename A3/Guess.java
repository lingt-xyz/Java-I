package A3;
import java.util.Scanner;

public class Guess {

	/**
	 * Command for guessing by word
	 */
	private static final char GUESS_WORD = 'g';
	/**
	 * Command for giving up
	 */
	private static final char GIVE_UP = 't';
	/**
	 * Command for guessing by letter
	 */
	private static final char GUESS_LETTER = 'l';
	/**
	 * Command for quitting the game
	 */
	private static final char QUIT = 'q';

	/**
	 * Current command
	 */
	private char currentAction = ' ';
	private Game game = null;
	/**
	 * Is the current game finished
	 */
	private boolean gameEnd = false;
	private Scanner keyboard = null;

	/**
	 * get a new instance of Game
	 */
	public Guess() {
		game = new Game();
	}

	public static void main(String[] args) {
		Guess guess = new Guess();
		guess.runGuess();
	}

	/**
	 * Begin to guess
	 */
	private void runGuess() {
		keyboard = new Scanner(System.in);
		do {
			reStartGame();
			do {
				printMainMenu();
				currentAction = keyboard.next().toLowerCase().charAt(0);
				switch (currentAction) {
				case GUESS_WORD:
					guessByWord();
					break;
				case GIVE_UP:
					giveUp();
					break;
				case GUESS_LETTER:
					guessByLetter();
					break;
				case QUIT:
					currentAction = QUIT;
					break;
				default:
					printInvalidInput();
					break;
				}
			} while (QUIT != currentAction && !gameEnd);
		} while (QUIT != currentAction && game.gameAvaliable());
		outputScore();
		keyboard.close();
	}

	/**
	 * start a new game.
	 */
	private void reStartGame() {
		game.start();
		printWelcomeInfo();
	}

	/**
	 * print out the main menu
	 */
	private void printMainMenu() {
		printCurrentGuess();
		System.out.println("g = guess, t = tell me, l for a letter, and q to quit");
	}

	/**
	 * guess the word by inputting a letter
	 */
	private void guessByLetter() {
		System.out.println("Enter a letter:");
		char input = keyboard.next().toLowerCase().charAt(0);
		game.guess(input);
		gameEnd = game.isFinished();
		printGuessResultByLetter();

	}

	/**
	 * print out the guess result
	 */
	private void printGuessResultByLetter() {
		if (gameEnd) {
			System.out.println("\nBingo! You found all the letters!");
		} else {
			System.out.println("\nYou found " + game.getAmountOfFoundLetters() + " letter(s)!");
		}
	}

	/**
	 * guess the word by inputting a whole a word
	 */
	private void guessByWord() {
		System.out.println("Enter a word:");
		String input = keyboard.next();
		game.guess(input);
		gameEnd = game.isFinished();
		printGuessResultByWord();

	}

	/**
	 * print out the guess result
	 */
	private void printGuessResultByWord() {
		if (gameEnd) {
			System.out.println("\nBingo! You found the word: " + game.getCurrentWord() + "!");
		} else {
			System.out.println("\nBad Guess!");
		}

	}

	private void giveUp() {
		game.giveUp();
		gameEnd = game.isFinished();
		printWord();
	}

	private void printWord() {
		System.out.println("\nThe word is: " + game.getCurrentWord());
	}

	/**
	 * print out the final game result
	 */
	private void outputScore() {
		Game[] gs = game.getScores();
		System.out.println("Game\tWord\tStatus\tBad Guesses\tMissed Letters\tScore");
		System.out.println("----\t----\t------\t-----------\t--------------\t-----");
		for (Game g : gs) {
			if (g != null) {
				System.out.println(g.toString());
			}
		}
		System.out.println("\nFinal Score: " + game.getFinalScore());
	}

	private void printWelcomeInfo() {
		System.out.println("\n\n** The great guessing game **\n");
	}

	/**
	 * out put what letters have been guessed out
	 */
	private void printCurrentGuess() {
		System.out.println("Current Guess: " + game.getCurrentGuess() + "\n\n");
	}

	private void printInvalidInput() {
		System.out.println("** Input is invalid! **\n");
	}

}
