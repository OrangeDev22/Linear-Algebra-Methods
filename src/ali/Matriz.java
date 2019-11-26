/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ali;

public class Matriz {

    private double matriz[][];
    private int x;
    private int y;
    private String nombre;
    public Matriz() {
    }

    public Matriz(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        matriz = new double [x][y];
    }

    public double [][] getMatriz() {
        return matriz;
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
   
}
