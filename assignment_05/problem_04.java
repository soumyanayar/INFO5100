public class problem_04 {

    public int getClosestOfTarget(int[] array, int target) {
        int length = array.length;
        if (length == 0) {
            return -1;
        }
        for (int i = 0, j = 1; i < length - 1; ++i, ++j) {
            if (target < array[0]) {
                return 0;
            } else if (target == array[i]) {
                return i;
            } else if (target > array[i] && target < array[j]) {
                int result = getClosest(array[i], array[j], target);
                if (result == array[i]) {
                    return i;
                } else {
                    return j;
                }
            }
        }
        return length - 1;
    }

    public int getClosest(int i, int j, int target) {
        if ((target - i) >= (j - target)) {
            return j;
        }
        return i;
    }

    public static void main(String[] args) {
        problem_04 obj = new problem_04();
        int[] array1 = { 1, 3, 7, 8, 12, 23, 25 };
        int target1 = 11;
        int result = obj.getClosestOfTarget(array1, target1);
        System.out.println("The index of tagert close to array item is : " + result);

        int[] array2 = {};
        int target2 = 11;
        result = obj.getClosestOfTarget(array2, target2);
        System.out.println("The index of tagert close to array item is : " + result);

        int[] array3 = { 11, 22, 33, 44, 55, 66, 77 };
        int target3 = 38;
        result = obj.getClosestOfTarget(array3, target3);
        System.out.println("The index of tagert close to array item is : " + result);

        int[] array4 = { 11, 22, 33, 44, 55, 66, 77 };
        int target4 = 80;
        result = obj.getClosestOfTarget(array4, target4);
        System.out.println("The index of tagert close to array item is : " + result);

    }
}
