public class Problem4 {
    public static int[] getPermutationPatternWithCondition(String input) {
        int iCounter = 0;
        int dCounter = input.length();
        int[] output = new int[input.length() + 1];
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c == 'I') {
                output[i] = iCounter++;
            } else if (c == 'D') {
                output[i] = dCounter--;
            }
        }
        output[input.length()] = iCounter;
        return output;
    }

    public static void main(String[] args) {
        String input1 = "IDID";
        int[] result1 = Problem4.getPermutationPatternWithCondition(input1);
        for (int val : result1) {
            System.out.print(val + " ");
        }
        System.out.println();

        String input2 = "III";
        int[] result2 = Problem4.getPermutationPatternWithCondition(input2);
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();

        String input3 = "DDI";
        int[] result3 = Problem4.getPermutationPatternWithCondition(input3);
        for (int val : result3) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
