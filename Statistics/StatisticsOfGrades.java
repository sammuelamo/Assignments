package Assignments;

public class StatisticsOfGrades {

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            //int[] grades = new int[5];
            Scanner input = new Scanner(System.in);
            System.out.println("Input the grades with spaces");

            //Accepting user input
            String GRADES = input.nextLine();
            String[] stringGrades = GRADES.split(" ");

            // declaring an array to store the grades of the user
            int[] numGrades = new int[stringGrades.length];
            for (int i = 0; i < numGrades.length; i++) {
                numGrades[i] = Integer.parseInt(stringGrades[i]);
            }

            int minValue = numGrades[0]; //Min grade
            int maxValue = numGrades[0];  //Max grade
            int totalGrades = 0;  //Average grade

            //Extracting the minimum and maximum grade from the list of grades
            for (int i = 0; i < numGrades.length; i++) {
                if (numGrades[i] < minValue){
                    minValue = numGrades[i];
                }
                if (numGrades[i] > maxValue){
                    maxValue = numGrades[i];
                }
                totalGrades+=numGrades[i];

            }
            float averageGrade = (float) totalGrades /numGrades.length; // Calculating total average grade

            System.out.println("The Maximum grade is : " + maxValue);
            System.out.println("The Minimum grade is : " + minValue);
            //System.out.println("Total: " + totalGrades);
            System.out.println("The average grade is : " + averageGrade);

            //Splitting grades to its respective category
            int[] stats = new int[5];
            for (int numGrade : numGrades) {
                if (numGrade >= 0 && numGrade <= 20) {
                    stats[0]++;
                } else if (numGrade >= 21 && numGrade <= 40) {
                    stats[1]++;
                } else if (numGrade >= 41 && numGrade <= 60) {
                    stats[2]++;
                } else if (numGrade >= 61 && numGrade <= 80) {
                    stats[3]++;
                } else if (numGrade >= 81 && numGrade <=100) {
                    stats[4]++;
                }

            }
            //System.out.println(Arrays.toString(stats));

            int maxCount = Arrays.stream(stats).max().getAsInt(); // MAximun count of the stats grades
            //System.out.println("Max Count: " + maxCount);

            //Displaying the frequency of the grades on the x axis
            System.out.println("Graph");
            for(int i = maxCount; i > 0; i--){
                System.out.print(i + "     > ");
                for(int count:stats){
                    if (count >= i){
                        System.out.print("         #######  ");
                    }else {
                        System.out.print("                  ");
                    }
                }
                System.out.println();
            }
            //displaying the categories on the x axis
            String[] y_labels = {"0 - 20", "21 - 40", "41 - 60", "61 - 80", "81 - 100"};
            for (int i = 0; i < stats.length; i++) {
                if (i == 0){
                    System.out.print("      +-----------------");
                }else {
                    System.out.print("+-----------------");
                }

            }
            //printing the labels of the y axis
            System.out.print("+");
            System.out.println();
            for (int i = 0; i < stats.length; i++) {
                if (i == 0){
                    System.out.print("      I" + "      "+ y_labels[i]);

                }else {
                    System.out.print("     I" + "     "+ y_labels[i]);
                }

            }
            System.out.print("    I");

        }

    }
}
