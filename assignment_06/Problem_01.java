public class Problem_01 {
    public static void main(String[] args) throws MyIndexOutOfBoundException {
        int[] array = { 0, 1, 2, 3, 4, 5, 6 };
        int indexToAccess = 15;
        try {
            System.out.println(array[indexToAccess]);
        } catch (IndexOutOfBoundsException iobe) {
            try {
                throw new MyIndexOutOfBoundException(array, indexToAccess);
            } catch (MyIndexOutOfBoundException miobe) {
                System.out.println(miobe.getMessage());
            }
        }
    }
}

class MyIndexOutOfBoundException extends Exception {
    private static final long serialVersionUID = 1L;
    private int index;
    private int upperBound;
    private int lowerBound;

    public MyIndexOutOfBoundException(int[] array, int index) {
        this.index = index;
        this.upperBound = array.length - 1;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Error Message: Index " + this.index + ", but Lower bound: " + this.lowerBound + ", Upper bound: "
                + this.upperBound;
    }
}
