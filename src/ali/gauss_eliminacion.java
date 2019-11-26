/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ali;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class gauss_eliminacion {

    private double[] solution;

    public void solve(double[][] A, double[] B) {
        int N = B.length;
        int M = A.length;
        System.out.println("N_" + N);
        System.out.println("M_" + M);
        for (int k = 0; k < M; k++) {
            /**
             * find pivot row *
             */
            int max = k;
            for (int i = k + 1; i < N; i++) {
                if (Math.abs(A[k][i]) > Math.abs(A[max][k]) && M < N) {
                    max = k;
                } else if (Math.abs(A[k][i]) > Math.abs(A[max][k]) && N < M) {
                    max = i;
                }
            }

            /**
             * swap row in A matrix *
             */
            System.out.println("max_" + max);
            System.out.println("K__" + k);
            double[] temp = A[k];
            System.out.println(temp[k]);
            A[k] = A[max];
            A[max] = temp;

            /**
             * swap corresponding values in constants matrix *
             */
            double t = B[k];
            B[k] = B[max];
            B[max] = t;

            /**
             * pivot within A and B *
             */
            for (int i = k + 1; i < M; i++) {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++) {
                    A[i][j] -= factor * A[k][j];
                }
            }
        }

        /**
         * Print row echelon form *
         */
        printRowEchelonForm(A, B);

        /**
         * back substitution *
         */
        solution = new double[N];
        for (int i = M - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * solution[j];
            }
            solution[i] = (B[i] - sum) / A[i][i];
        }
        /**
         * Print solution *
         */
        printSolution(solution);
    }

    /**
     * function to print in row echleon form *
     */
    public String printRowEchelonForm(double[][] A, double[] B) {
        int N = B.length;
        int M = A.length;
        String devolver = "La matriz resultante es: \n";
        System.out.println("\nRow Echelon form : ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                devolver += String.format("%.3f ", A[i][j]);
            }
            devolver += String.format("| %.3f\n", B[i]);
        }
        devolver += "\n";

        return devolver;
    }

    /**
     * function to print solution *
     */
    public String printSolution(double[] sol) {
        String devolver = "Las soluciones son: \n";
        int N = sol.length;
        for (int i = 0; i < N; i++) {
            devolver += "X" + (i + 1) + "= " + String.format("%.3f ", sol[i]);
            devolver += "\n";
        }
        return devolver;
    }

    public double[] getSolution() {
        return solution;
    }

    public void setSolution(double[] solution) {
        this.solution = solution;
    }

}
