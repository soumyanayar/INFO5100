import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_04 {
    public static boolean uniqueOccurance(int[] array) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : array) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        Set<Integer> uniqueOccurances = new HashSet<>(hashMap.values());
        return hashMap.values().size() == uniqueOccurances.size();
    }

    public static void main(String[] args) {
        int[] inputArray1 = { 1, 2, 2, 1, 1, 3 };
        System.out.println(Problem_04.uniqueOccurance(inputArray1));

        int[] inputArray2 = { 1, 2 };
        System.out.println(Problem_04.uniqueOccurance(inputArray2));

        int[] inputArray3 = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(Problem_04.uniqueOccurance(inputArray3));
    }
}
