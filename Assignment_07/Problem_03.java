import java.util.Arrays;

public class Problem_03 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        boolean result = Arrays.equals(array1, array2);
        return result;
    }

    public static void main(String[] args) {
        String s1 = "car";
        String t1 = "rat";
        boolean result = isAnagram(s1, t1);
        System.out.println("\n The give strings are Anagrams : " + result);

        String s2 = "anagram";
        String t2 = "nagaram";
        result = isAnagram(s2, t2);
        System.out.println("\n The give strings are Anagrams : " + result);
    }

}
