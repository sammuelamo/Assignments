package Assignments;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrizMultiplication {
    public static void main(String[] args) throws IOException , InputMismatchException, IllegalArgumentException{
        Scanner getUserInput = new Scanner(System.in);

        // Getting the user input for the first matrix A
        System.out.print("Matrix A: ");
        String row_column_A = getUserInput.nextLine();
        String[] row_columnA = row_column_A.split(",");
        int row_A = Integer.parseInt(row_columnA[0].trim());
        int column_A = Integer.parseInt(row_columnA[1].trim());

        // initializing the first matrix
        int[][] matrix_A = new int[row_A][column_A];
        for (int i = 0; i < row_A; i++) {
            for (int j = 0; j < column_A; j++) {
                matrix_A[i][j] = getUserInput.nextInt();
            }
        }
        //printMatrix(matrix_A);


        // getting user input for the second for second matrix B
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matrix B: ");
        String row_column_B = scanner.nextLine();
        String[] row_columnB = row_column_B.split(",");
        int row_B = Integer.parseInt(row_columnB[0].trim());
        int column_B = Integer.parseInt(row_columnB[1].trim());

        // initializing the second matrix B
        int[][] matrix_B = new int[row_B][column_B];
        for (int i = 0; i < row_B; i++) {
            for (int j = 0; j < column_B; j++) {
                matrix_B[i][j] = scanner.nextInt();
            }
        }
        //printMatrix(matrix_B);
        scanner.close();



    /*
    int[][] matrixA = {{12,2,4},{10,1,1}};
    int[][] matrixB = {{2,2},{1, 2}, {1,1}};
    printMatrix(matrixA);
    */
        System.out.println();
        System.out.println("Matrix C: ");


        //printMatrix(multiplyTwoMatrice(matrix_A, matrix_B));
        int[][] result = multiplyTwoMatrice(matrix_A, matrix_B);
        printMatrix(result);



    }

    //method to perform the multiplication on the array
    public static int[][] multiplyTwoMatrice(int[][] matriceA, int[][] matriceB) {

        int row_A = matriceA.length;
        int column_A = matriceA[0].length;
        int row_B = matriceB.length;
        int column_B = matriceB[0].length;
        if (column_A != row_B) {
            throw new IllegalArgumentException("MatrixA columns must be equal to MatrixB rows");
        }

        int[][] results_C = new int[row_A][column_B];

        /*
        The outer loop (i) iterates over each row of matrix A.
        The middle loop (j) iterates over each column of matrix B
        The innermost loop (k) iterates over the elements of the current row of matrix A and the current column of matrix B.
        For each element results_C[i][j], it adds the product of matriceA[i][k] and matriceB[k][j].
        */

        for (int i = 0; i < row_A; i++) {
            for (int j = 0; j < column_B; j++) {
                for (int k = 0; k < column_A; k++) {
                    results_C[i][j] += matriceA[i][k] * matriceB[k][j];
                }
            }
        }
        return results_C;
    }

    //function to print the contents of matrix C
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }



}





