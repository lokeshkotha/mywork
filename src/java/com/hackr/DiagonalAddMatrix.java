/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.hackr;

import java.util.Scanner;

/**
 *
 * @author Lokesh Kotha
 */
public class DiagonalAddMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sumOfDiagonal1 = 0;
        int sumOfDiagonal2 = 0;
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = in.nextInt();
                if (a_i == a_j) {
                    sumOfDiagonal1 += a[a_i][a_j];
                }
                if (a_i == n - a_j - 1) {
                    System.out.println(a_i);
                    System.out.println(a_j);
                    System.out.println(n);
                    sumOfDiagonal2 += a[a_i][a_j];
                }
            }
        }

        int result = sumOfDiagonal1 - sumOfDiagonal2;
        System.out.println(Math.abs(result));
        in.close();
    }
}
