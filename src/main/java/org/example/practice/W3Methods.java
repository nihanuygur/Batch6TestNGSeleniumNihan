package org.example.practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class W3Methods {


    /*
      Write a Java program to print the following grid. Method - Dynamic
      Expected Output :
              - - - - - - - - - -
              - - - - - - - - - -
              - - - - - - - - - -
              - - - - - - - - - -
              - - - - - - - - - -
              - - - - - - - - - -
              - - - - - - - - - -
              - - - - - - - - - -
              - - - - - - - - - -
              - - - - - - - - - -
     */
    public static void arrayGrid(int row, int column) {
        String[][] grids = new String[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grids[i][j] = "-";
                if (j < column - 1) {
                    System.out.print(grids[i][j] + " ");
                } else {
                    System.out.print(grids[i][j]);
                }
            }
            System.out.println();
        }
    }

    /*
    Write a Java method to count all vowels in a string.
    Test Data:
    Input the string: w3resource
    Expected Output:
    Number of  Vowels in the string: 4
    */
    public static void countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.toLowerCase().charAt(i) == 'a' || str.toLowerCase().charAt(i) == 'e'
                    || str.toLowerCase().charAt(i) == 'u' || str.toLowerCase().charAt(i) == 'o'
                    || str.toLowerCase().charAt(i) == 'i') {
                count++;
            }
        }
        System.out.println("Number of  Vowels in the string: " + count);
    }
    /*
     Write a Java method to count all words in a string.
     Test Data:
     Input the string: The quick brown fox jumps over the lazy dog.
     Expected Output:
     Number of words in the string: 9
     */

    public static void countWords(String str) {

        String[] words = str.trim().split(" ");
        System.out.println("Number of words in the string: " + words.length);
    }

}
