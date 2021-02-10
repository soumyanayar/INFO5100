import java.util.Arrays;

public class Problem6 {
    public String reverseSentence(String str) {
        String[] words = str.split(" ");
        String[] reverseWords = new String[words.length];
        for (int i = words.length - 1, j = 0; i >= 0; --i, ++j) {
            reverseWords[j] = words[i];
        }
        return String.join(" ", Arrays.asList(reverseWords));
    }

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        String sentence = "the sky is blue";
        String reverseOfSentence = problem6.reverseSentence(sentence);
        System.out.println("Reverse of " + sentence + " is: " + reverseOfSentence);
    }
}
