package A3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The purpose of the StringDatabase class is primarily to load the array with four letter words.
 * 
 * @author eavis
 *
 */
public class StringDatabase {

	public static final int DB_SIZE = 4030;
	private static final String IN_FILE = "src/A3/four_letters.txt";

	String[] database = null; // the array of 4-letter strings

	/**
	 * The StringDatabase constructor opens the file containing the 4-letter words and reads its contents into String array
	 */
	public StringDatabase() {

		database = new String[DB_SIZE];
		try {
			// Reading input by lines:
			BufferedReader in = new BufferedReader(new FileReader(IN_FILE));

			String input;
			int wordCount = 0;

			while ((input = in.readLine()) != null) {
				String[] pieces = input.split("\\s");
				for (int i = 0; i < pieces.length; i++)
					database[wordCount++] = pieces[i];
			}
			in.close();

		} catch (FileNotFoundException e) {
			System.err.println("Sorry but " + IN_FILE + " isn't here!");
		} catch (IOException e) {
			System.err.println("An IO exception occurred");
		}
	}

}
