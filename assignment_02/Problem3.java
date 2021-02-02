// Write a method that takes a String and character as input and find how many characters are in the String

public class Problem3 {
    public int characterCountInString(String s, char c) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        String testCaseString1 = "Yashaswini";
        char target = 'a';
        int charCount = problem3.characterCountInString(testCaseString1, target);
        System.out.println(
                "The letter " + target + " in the string: " + testCaseString1 + " repeated " + charCount + " times");

        String testCaseString2 = "Leena";
        target = 'e';
        charCount = problem3.characterCountInString(testCaseString2, target);
        System.out.println(
                "The letter " + target + " in the string: " + testCaseString2 + " repeated " + charCount + " times");

        String testCaseString3 = null;
        target = 'e';
        charCount = problem3.characterCountInString(testCaseString3, target);
        System.out.println(
                "The letter " + target + " in the string: " + testCaseString3 + " repeated " + charCount + " times");
    }
}
