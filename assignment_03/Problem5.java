public class Problem5 {
    public String countAndSay(int number) {
        if (number <= 0 || number > 30) {
            return "expected 'number' to have value from 1 to 30 only";
        }
        String result = "1";
        if (number == 1) {
            return result;
        }
        for (int i = 1; i < number; i++) {
            char c = result.charAt(0);
            StringBuilder temp = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {
                if (c != result.charAt(j)) {
                    temp.append(count);
                    temp.append(c);
                    count = 0;
                    c = result.charAt(j);
                }
                count++;
            }
            temp.append(count);
            temp.append(c);
            result = temp.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        String result = problem5.countAndSay(6);
        System.out.println(result);
    }
}
