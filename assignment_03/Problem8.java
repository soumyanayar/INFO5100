import java.util.ArrayList;
import java.util.List;

public class Problem8 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() <= numRows || numRows == 1) {
            return s;
        }
        List<List<Character>> resList = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++) {
            resList.add(new ArrayList<Character>());
        }
        for (int i = 0; i < s.length(); i++) {
            int indexInGroup = i % (2 * numRows - 2);
            int indexInList;
            if (indexInGroup < numRows) {
                indexInList = indexInGroup;
            } else {
                indexInList = 2 * numRows - 2 - indexInGroup;
            }
            resList.get(indexInList).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : resList) {
            for (Character c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem8 problem8 = new Problem8();
        String str = "PAYPALISHIRING";
        int rows1 = 4;
        String result = problem8.convert(str, rows1);
        System.out.println(result);
        System.out.println("\n***************\n");

        int rows2 = 3;
        String result2 = problem8.convert(str, rows2);
        System.out.println(result2);

    }

}
