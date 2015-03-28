/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga.siment;

import java.io.PrintStream;
import java.util.Random;

/**
 *
 * @author hasaan
 */
public class Chromosome {

    private final int noOfSides, interiorAngle;
    private final double fitnessValue;

    static Random random = new Random();
    static PrintStream stdout = System.out;

    public Chromosome() {
        noOfSides = random.nextInt(10) + 1; //1 to 10
        interiorAngle = random.nextInt(361); //0 to 360
        fitnessValue = evaluate();
    }

    public Chromosome(Chromosome one, Chromosome two) {
        noOfSides = one.getNoOfSides(); //1 to 10
        interiorAngle = two.getInteriorAngle(); //0 to 360
        fitnessValue = evaluate();
    }

    public int getNoOfSides() {
        return noOfSides;
    }

    public int getInteriorAngle() {
        return interiorAngle;
    }

    public double getFitnessValue() {
        return fitnessValue;
    }

    private double evaluate() {
        //evaluate (scale) values of both variables from 0(worst) to 1(best)
        double x = (Math.abs(noOfSides - 6) - 0) / 5.0;
        double y = (Math.abs(interiorAngle - 120) - 0) / 240.0;
        return 1 - ((x + y) / 2);
    }

    public void print() {
        stdout.println(noOfSides + " | " + interiorAngle);
    }
    public void printFitness() {
        stdout.println(fitnessValue);
    }
}
