package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int matrixRows, matrixCols;

        System.out.println("Enter amount of rows [n] greater or equal than 2");
        matrixRows = checkInput(scan);

        System.out.println("Enter amount of cols [m] greater or equal than 2");
        matrixCols = checkInput(scan);

        int[][] matrix = new int[matrixRows][matrixCols];

        ramdomizeMatrix(matrix, matrixRows, matrixCols);

        int qtyCols = processData(matrix, matrixRows, matrixCols);

        System.out.println("There is " + Integer.toString(qtyCols) + " cols above average of summatory of odd cols");
    }

    public static int checkInput(Scanner scan) {
        int input, counter = 0;

        do{
            input = scan.nextInt();
            if(input >= 2) {
                return input;
            }else if(counter++ == 3){
                throw new IllegalArgumentException("Invalid input from user");
            }else{
                System.out.println("You must have enter values greater or equal than 2");
            }
        }while(true);
    }

    public static int getRamdomNumber(int max) {
        Random r = new Random();
        return r.nextInt(max) + 1;
    }

    public static void ramdomizeMatrix(int[][] matrix, int rows, int cols) {
        System.out.println("-------------------------");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                matrix[i][j] = getRamdomNumber(rows * cols);
                System.out.printf("| %03d | ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public static int processData(int[][] matrix, int rows, int cols){
        double average = 0d;
        int[] sum = new int[cols];
        int counter = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                sum[j] += matrix[i][j];
            }
        }
        for (int j = 0; j < cols; j++){
            System.out.printf("| %03d | ", sum[j]);
        }
        System.out.println();
        System.out.println("-------------------------");

        for (int j = 0; j < cols; j += 2){
            average += (double) sum[j];
        }
        average /= (double) ((cols / 2) + 1);
        System.out.printf("Average sumatory odd cols: %03.2f", average);
        System.out.println();

        for(int j = 0; j < cols; j++){
            if(sum[j] > average){
                counter++;
            }
        }
        return counter;
    }
}
