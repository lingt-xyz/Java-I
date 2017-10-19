package A3;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Game {

	/**
	 * Game Status
	 */
	private static final String STATUS_SUCESS = "Sucess";
	private static final String STATUS_GIVEUP = "Gave up";

	/**
	 * Letter Frequency for calculating score
	 */
	private static final double[] LETTER_FRQUENCY = { 8.17, 1.49, 2.78, 4.25, 12.7, 2.23, 2.02, 6.09, 6.97, 0.15, 0.77, 4.03, 2.41, 6.75, 7.51, 1.93, 0.10, 5.99, 6.33, 9.06, 2.76, 0.98, 2.36, 0.15, 1.97, 0.07 };

	/**
	 * Save played games. Up to 100
	 */
	private static Game[] GAME_ARRAY = new Game[100];

	/**
	 * A counter for how many games did you play
	 */
	private static int GAME_INDEX = 0;

	/**
	 * After quit, calculate the final score.
	 */
	private static double FINAL_SCORE = 0.0;

	/**
	 * Currently, you are playing the nth game.
	 */
	private int gameIndex = 0;

	/**
	 * Words going to be guessed
	 */
	private String[] database = null;

	/**
	 * Select a word from database randomly
	 */
	private Random r = null;

	/**
	 * Which word was selected from database
	 */
	private String currentWord = null;

	/**
	 * What have been guessed
	 */
	private char[] baseArray = null;

	/**
	 * What have not been guessed
	 */
	private String uncoveredLetters = null;

	/**
	 * The status of the game are currently been playing.
	 */
	private String status = null;

	/**
	 * A counter for bad guesses
	 */
	private int badGuesses = 0;

	/**
	 * A counter for how many times did the word be guessed
	 */
	private int timeGuesses = 0;

	/**
	 * How many letters have been guessed
	 */
	private int amountGuessed = 0;

	/**
	 * How many letters have not been guessed
	 */
	private int missedLetters = 0;

	/**
	 * If the word is guessed out or game is quitted, then isFinished is true.
	 */
	private boolean isFinished = false;

	/**
	 * The score of current game
	 */
	private double score = 0.0;

	/**
	 * Initialize database
	 */
	public Game() {
		StringDatabase stringDatabase = new StringDatabase();
		this.database = stringDatabase.database;
		r = new Random();
	}

	/**
	 * Copy constructor
	 * 
	 * @param gameIndex
	 *            the index of current game
	 * @param currentWord
	 *            the word to be guessed
	 * @param status
	 *            the status of the game
	 * @param badGuesses
	 *            the time of bad guess
	 * @param missedLetters
	 *            the number of missed letters
	 * @param score
	 *            the score of current game
	 */
	private Game(int gameIndex, String currentWord, String status, int badGuesses, int missedLetters, double score) {
		this.gameIndex = gameIndex;
		this.currentWord = currentWord;
		this.status = status;
		this.badGuesses = badGuesses;
		this.missedLetters = missedLetters;
		this.score = score;
	}

	/**
	 * Start the game
	 */
	public void start() {
		currentWord = database[r.nextInt(StringDatabase.DB_SIZE)];
		initParams();
	}

	/**
	 * Guess the word by input a whole word
	 * 
	 * @param word
	 *            the input word
	 */
	public void guess(String word) {
		++timeGuesses;
		if (currentWord.equals(word)) {
			missedLetters = 0;
			isFinished = true;
			status = STATUS_SUCESS;
		} else {
			++badGuesses;
		}
	}

	/**
	 * Guess the word by input a letter
	 * 
	 * @param c
	 *            the input letter
	 */
	public void guess(char c) {
		amountGuessed = 0;
		++timeGuesses;
		int indexFound = 0;
		do {
			indexFound = currentWord.indexOf(c, indexFound);
			if (indexFound != -1) {
				if (uncoveredLetters.indexOf(c) == -1) {
					// if the player input the same letter again, we should ignore the input
				} else {
					// otherwise, we should know this is a new letter that has been guessed
					--missedLetters;
				}
				baseArray[indexFound] = c;
				++amountGuessed;
				++indexFound;
			} else {
				break;
			}
		} while (indexFound < currentWord.length());
		if (currentWord.equals((new String(baseArray)))) {
			isFinished = true;
			status = STATUS_SUCESS;
		} else {
			uncoveredLetters = uncoveredLetters.replaceAll(String.valueOf(c), "");
		}
	}

	/**
	 * Give up guess
	 */
	public void giveUp() {
		status = STATUS_GIVEUP;
		isFinished = true;
	}

	/**
	 * Get how many letters have been found
	 * 
	 * @return
	 */
	public int getAmountOfFoundLetters() {
		return amountGuessed;
	}

	/**
	 * Get the letters in the word that have been found
	 * 
	 * @return the letters in the word that have been found, unfounded letters will be presented by '-'
	 */
	public String getCurrentGuess() {
		System.out.println(currentWord);
		return new String(baseArray);
	}

	/**
	 * Get the word to be guessed
	 * 
	 * @return the word to be guessed
	 */
	public String getCurrentWord() {
		return currentWord;
	}

	/**
	 * Check whether the game has been finished; if finished, save the current game. This method should be invoked after making each guess and when give up.
	 * 
	 * @return whether the game has been finished
	 */
	public boolean isFinished() {
		if (isFinished) {
			saveCurrentGame();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the array of all the games that have been played.
	 * 
	 * @return the array of all the games that have been played
	 */
	public Game[] getScores() {
		double totalScore = 0.0;
		int times = 0;
		for (Game g : GAME_ARRAY) {
			if (g != null) {
				totalScore += g.score;
				++times;
			}

		}
		if (times != 0) {
			FINAL_SCORE = totalScore / times;
		}
		return GAME_ARRAY.clone();
	}

	/**
	 * Get the final score
	 * 
	 * @return the final score
	 */
	public double getFinalScore() {
		return Double.valueOf(new DecimalFormat("#.##").format(FINAL_SCORE));
	}

	/**
	 * Check whether the player has played 100 times.
	 * 
	 * @return True, if no more than 100; otherwise, false.
	 */
	public boolean gameAvaliable() {
		return GAME_INDEX <= 100;
	}

	/**
	 * Calculate the score of the current game.
	 * 
	 * @return the score of the current game
	 */
	private double calculateScore() {
		char[] letters = uncoveredLetters.toCharArray();
		double frequency = 0.0;
		for (char c : letters) {
			frequency += (LETTER_FRQUENCY[c - 97]);
		}
		if (status.equals(STATUS_SUCESS)) {
			score = frequency / timeGuesses * (1 - badGuesses * 0.1);
		} else {
			score = -frequency;
		}
		score = Double.valueOf(new DecimalFormat("#.##").format(score));
		return score;
	}

	/**
	 * Save the current game to the game array
	 */
	private void saveCurrentGame() {
		this.score = calculateScore();
		gameIndex = GAME_INDEX + 1;
		GAME_ARRAY[GAME_INDEX] = new Game(gameIndex, currentWord, status, badGuesses, missedLetters, score);
		++GAME_INDEX;
	}

	private void initParams() {
		baseArray = new char[] { '-', '-', '-', '-' };
		uncoveredLetters = currentWord;
		status = null;
		badGuesses = 0;
		timeGuesses = 0;
		amountGuessed = 0;
		missedLetters = uncoveredLetters.length();
		isFinished = false;
		score = 0.0;
	}

	public String toString() {
		return gameIndex + "\t" + currentWord + "\t" + status + "\t" + badGuesses + "\t\t" + missedLetters + "\t\t" + score;
	}

	public boolean equals(Game other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (amountGuessed != other.amountGuessed)
			return false;
		if (badGuesses != other.badGuesses)
			return false;
		if (!Arrays.equals(baseArray, other.baseArray))
			return false;
		if (currentWord == null) {
			if (other.currentWord != null)
				return false;
		} else if (!currentWord.equals(other.currentWord))
			return false;
		if (!Arrays.equals(database, other.database))
			return false;
		if (gameIndex != other.gameIndex)
			return false;
		if (isFinished != other.isFinished)
			return false;
		if (missedLetters != other.missedLetters)
			return false;
		if (score != other.score)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeGuesses != other.timeGuesses)
			return false;
		if (uncoveredLetters == null) {
			if (other.uncoveredLetters != null)
				return false;
		} else if (!uncoveredLetters.equals(other.uncoveredLetters))
			return false;
		return true;
	}
}
