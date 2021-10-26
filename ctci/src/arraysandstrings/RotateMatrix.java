package arraysandstrings;

/**
 * ZeroMatrix
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2001.%20Arrays%20and%20Strings/Q1_07_Rotate_Matrix
 * Difficulty : Easy
 * Related Topics : Array, String
 *
 * created by Cenk Canarslan on 2021-10-25
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4},
                {6,  7,  8,  9},
                {11, 12, 13, 14},
                {16, 17, 18, 19}};

//        rotateMatrixUsingAuxiliaryMatrix(matrix);
        rotateMatrixInPlace(matrix);
    }

    public static void rotateMatrixUsingAuxiliaryMatrix(int[][] matrix) {
        int length = matrix.length;
        int[][] aux = new int[length][length];
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                aux[col][length - row - 1] = matrix[row][col];
            }
        }
        printMatrix(aux);
    }

    /**
     * Solution by: https://github.com/gaylelaakmann
     *
     * @param matrix
     */
    public static boolean rotateMatrixInPlace(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        printMatrix(matrix);
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        System.out.println("------------------------");
        printMatrix(matrix);
        return true;
    }
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("matrix["+i+"]["+j+"] = " + matrix[i][j]);
            }
        }
    }
}
