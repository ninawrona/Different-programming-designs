import java.util.Arrays;

//Solving Sudoku using a backtracking algorithm
public class Sudoku {

    // N is the size of the 2D matrix = 9
    private static final int MATRIX_SIZE = 9;

    public static boolean SolveSudoku(int[][] matrix, int row, int column) {

         /*if we have reached the 8th
           row and 9th column (0
           indexed matrix) ,
           we are returning true to avoid further
           backtracking       */
        if(row == MATRIX_SIZE-1 && column == MATRIX_SIZE){
            return true;
        }

        // Check if column value  becomes 9 ,
        // we move to next row
        // and column start from 0
        if (column == MATRIX_SIZE) {
            row++;
            column = 0;
        }

        // Check if the current position
        // of the grid already
        // contains value >0, we iterate
        // for next column
        if(matrix[row][column] != 0){
            return SolveSudoku(matrix, row, column+1);
        }

        for(int num = 1; num<10; num++){

            // Check if it is safe to place
            // the num (1-9)  in the
            // given row ,col ->we move to next column
            if(isSafe(matrix, row, column, num)){

                matrix[row][column] = num;

                if(SolveSudoku(matrix, row, column+1)){
                    return true;
                }
            }
             /* removing the assigned num , since our
               assumption was wrong , and we go for next
               assumption with diff num value   */
            matrix[row][column] = 0;
        }

        return false;
    }

    private static boolean isSafe(int[][] matrix, int row, int column, int num) {

        for(int i = 0; i<MATRIX_SIZE; i++){
            if(matrix[row][i] == num){
                return false;
            }
        }

        for(int i = 0; i<MATRIX_SIZE; i++){
            if(matrix[i][column] == num){
                return false;
            }
        }

        return true;
    }

    static void print(int[][] grid)
    {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(SolveSudoku(matrix, 0, 0)){
            print(matrix);
        }
        else{
            System.out.println("No Solution exists");
        }

    }
}
