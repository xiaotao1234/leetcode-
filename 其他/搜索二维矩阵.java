package 其他;

/**
 * Created by Xiao Tao on 2020/2/29 9:29
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target)
                row++;
            else if (matrix[row][col] > target)
                col--;
            else
                return true;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrixReserve(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return get(matrix,matrix.length,matrix[0].length,target);
    }

    public boolean get(int[][] matrix, int row, int col, int target) {
        if (row > matrix.length || col < 0) {
            return false;
        }
        if (matrix[row][col] < target) {
            return get(matrix, row + 1, col, target);
        } else if (matrix[row][col] > target) {
            return get(matrix, row, col - 1, target);
        } else {
            return true;
        }
    }
}
