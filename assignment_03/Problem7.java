import java.util.ArrayList;
import java.util.List;

public class Problem7 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null) {
            return res;
        }
        if (matrix.length == 0) {
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; ++i) {
                res.add(matrix[rowBegin][i]);
            }
            ++rowBegin;
            for (int i = rowBegin; i <= rowEnd; ++i) {
                res.add(matrix[i][colEnd]);
            }
            --colEnd;
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; --i) {
                    res.add(matrix[rowEnd][i]);
                }
                --rowEnd;
            }
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; --i) {
                    res.add(matrix[i][colBegin]);
                }
                ++colBegin;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(problem7.spiralOrder(matrix1));

        int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(problem7.spiralOrder(matrix2));
    }

}
