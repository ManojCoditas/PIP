/*
Input: Hello World from Java
Expected Output: Java from World Hello
*/
public class _5_Reverse_words_in_a_string {

    public String reverseWords(String s) {
        String[] words = s.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        _5_Reverse_words_in_a_string solution = new _5_Reverse_words_in_a_string();

        String input = "Hello World from Java";

        String output = solution.reverseWords(input);

        System.out.println("Reversed Output: " + output);
    }
}
