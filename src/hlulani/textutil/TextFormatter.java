package hlulani.textutil;

/**
 * Utility class providing methods for cleaning and standardizing text strings.
 *
 * @author Hlulani Ndlovu (HlulaniNdlovu-dev)
 * @version 1.0
 */
public class TextFormatter {

    /**
     * Normalizes the spacing within a string by replacing all sequences of one
     * or more whitespace characters with a single space.
     * * <p>
     * The method handles the following types of whitespace:
     * <ul>
     * <li>Space characters (' ')</li>
     * <li>Tab characters ('\t')</li>
     * <li>Newline characters ('\n' and '\r')</li>
     * </ul>
     * <p>
     * It also removes leading and trailing spaces from the final result.</p>
     *
     * @param text The input string that needs whitespace normalization.
     * @return The string with all whitespace compacted to single spaces, or
     * null if the input is null.
     */
    public static String normalizeWhitespace(String text) {
        String normalizedStr = "";
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isWhitespace(c)) {
                if (!Character.isWhitespace(text.charAt(i - 1))) {
                    word += " ";
                    normalizedStr += word;
                    word = "";
                }

            } else {
                word += c;
            }
        }

        return normalizedStr.trim();
    }

    /**
     * Normalizes the spacing in a string (replacing all sequences of whitespace
     * with a single space) and then splits the resulting string into an array
     * of words using that single space as the delimiter.
     *
     * <p>
     * This process effectively tokenizes the string by any whitespace (spaces,
     * tabs, newlines) while ignoring extra or consecutive delimiters.</p>
     *
     * @param text The input string to be normalized and split.
     * @return A String array containing the individual words (tokens) from the
     * text. Returns an empty array if the input text is null or empty.
     */
    public static String[] cleanAndSplitToWords(String text) {
        String[] arr = normalizeWhitespace(text).split(" ");
        return arr;
    }

    /**
     * First, normalizes the spacing in the input string by replacing all
     * sequences of one or more whitespace characters (spaces, tabs, new lines)
     * with a single space character (' ').
     *
     * <p>
     * Then, it converts the entire resulting normalized string—including the
     * single space characters—into a character array.</p>
     *
     * <p>
     * Example: "hello \t world" -> "hello world" (normalized string) -> {'h',
     * 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'} (char array)</p>
     *
     * @param text The input string to be normalized and converted.
     * @return A char array containing every character of the normalized string,
     * including spaces.
     */
    public static char[] normalizeAndToCharArray(String text) {
        String[] arr = normalizeWhitespace(text).split("");
        char[] charArr = new char[arr.length];

        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = arr[i].charAt(0);
        }
        return charArr;
    }
    
    public static String trimSymbols(String text) {
        String str = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                str += c;
            }
        }
        
        return str;
    }
}
