package A1;
/**
 * Poem analysis and Word substitution
 * 
 * @author Ling
 * @date May 16, 2016
 */
public class Q1 {

	public static final String POEM_LINE_1 = "Shall I compare thee to a summer's day";
	public static final String POEM_LINE_2 = "Thou art more lovely and more temperate";
	public static final String POEM_LINE_3 = "Rough winds do shake the darling buds of May";
	public static final String POEM_LINE_4 = "And summer's lease hath all too short a date";
	public static final int NUMBER_OF_LINES = 4;
	public static final String OLD_WORD = "thee";
	public static final String YOUR_NAME = "Ling";

	public static void main(String[] args) {
		int length = POEM_LINE_1.length() + POEM_LINE_2.length() + POEM_LINE_3.length() + POEM_LINE_4.length();
		float lengthPerLine = (length / (float) NUMBER_OF_LINES);
		System.out.println("Poem analysis:");
		System.out.println("The poem has " + length + " characters");
		System.out.printf("The average length per line is %.2f characters\n", lengthPerLine);
		System.out.println();

		int old_word_index = POEM_LINE_1.indexOf(OLD_WORD);
		String newString = POEM_LINE_1.substring(0, old_word_index) + YOUR_NAME + POEM_LINE_1.substring(old_word_index + OLD_WORD.length());
		System.out.println("The new poem is:");
		System.out.println(newString);
		System.out.println(POEM_LINE_2);
		System.out.println(POEM_LINE_3);
		System.out.println(POEM_LINE_4);

	}
}
