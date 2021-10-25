package arraysandstrings;

/**
 * ZeroMatrix
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_08_Zero_Matrix
 * Difficulty : Easy
 * Related Topics : Array, String
 *
 * created by Cenk Canarslan on 2021-10-25
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10,11},
                {13,14,15}};

//      Y
//      ^
//      |  1,   2,  3
//      |  5,   6,  7
//      |  9,  10, 11
//      |  13, 14, 15
//      |-------------> X

        setMatrix(matrix, 3, 2);
    }
    public static void setMatrix(int[][] matrix, int col, int row) {
        System.out.println("element = " + matrix[col][row]);
        int height = matrix.length;
        int width = matrix[0].length;
        System.out.println("height, width = " + height + ", " + width);
        for (int i = 0; i < width; i++) {
            matrix[col][i] = 0;
        }
        for (int j = 0; j < height; j++) {
            matrix[j][row] = 0;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("matrix["+i+"]["+j+"] = " + matrix[i][j]);
            }
        }
    }
}
