/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ali;

public class Vector {

    protected double dX[];
    protected double dY[];

    // Constructor methods ....
    public Vector() {

    }

    public double dot(double[] v, double v2[]) {
        double devolver = 0;
        for (int i = 0; i < v.length; i++) {
            devolver += v[i] * v2[i];
        }
        return devolver;
    }

    public double[] suma(double[] v, double v2[]) {
        double n[] = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            n[i] = v[i] + v2[i];
        }
        return n;
    }
}
