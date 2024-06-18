package Assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PeakColumns {
    public static void main(String[] args) throws IllegalArgumentException, InputMismatchException, NumberFormatException {

        Scanner getUserInput = new Scanner(System.in);

        // Getting the user input for the matrix
        System.out.print("Matrix A: ");
        String row_column_ = getUserInput.nextLine();
        String[] row_column = row_column_.split(",");
        int row = Integer.parseInt(row_column[0].trim());
        int column = Integer.parseInt(row_column[1].trim());

        //populating the user input to the matrix
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = getUserInput.nextInt();
            }
        }

        findPeakCoulumnsIn2DArray(matrix);

    }

    //function to print the resultant arrays
    public static void findPeakCoulumnsIn2DArray(int[][] matrix){
        int rows = matrix.length;
        int colums = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {

                if (isMaxValueInRow(matrix, i, j) && isMinValueInColumn(matrix, i, j)){
                    System.out.println("{" + (i + 1) + "," + (j + 1) + ") = " + matrix[i][j]);
                }

            }
        }
    }
    public static boolean isMaxValueInRow(int[][] matrix, int row, int column){
        int value = matrix[row][column];
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] > value){
                return false;
            }
        }

        return true;
    }


    public static boolean isMinValueInColumn(int[][] matrix, int row, int column){
        int value = matrix[row][column];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] < value){
                return false;
            }
        }

        return true;
    }
}
