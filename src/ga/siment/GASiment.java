/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga.siment;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hasaan
 */
public class GASiment {

    static int populationSize = 30;
    private static final Chromosome[] population = new Chromosome[populationSize];
    private static final PrintStream cout = System.out;

    public static void main(String[] args) {

        //generate population , evaluate
        cout.println("Creating initial population...");
        for (int i = 0; i < population.length; i++) {
            population[i] = new Chromosome();
            population[i].print();
            population[i].printFitness();
        }

        int iterations = 500;
        ArrayList<Chromosome> selected = new ArrayList<>();
        ArrayList<Chromosome> repopulation = new ArrayList<>();

        cout.println("\nStarting evolution...");
        for (int iterNo = 0; iterNo < iterations; iterNo++) {
            cout.println("\nIteration # " + (iterNo + 1));
            cout.println("Evaluating...");//this is done the moment new chromosomes are made
            cout.println("Selecting...");

            //selection
            double threshold = 0.7;
            selected.clear();
            while (selected.size() < 3) {
                for (int i = 0; i < population.length; i++) {
                    if (population[i].getFitnessValue() > threshold) {
                        if (population[i].getFitnessValue() > 0.8 && iterNo>2) {
                            cout.println("**********Evolved Enough! Found solution**********");
                            population[i].print();
                            population[i].printFitness();
                            return;
                        }
                        selected.add(population[i]);
                    }
                }
                threshold = threshold - 0.05;
            }
            cout.println("Selected " + selected.size() + " chroms");
//repopulate and evaluate
            cout.println("Repopulating...");
            Chromosome one, two;
            repopulation.clear();
            while (repopulation.size() < populationSize) {
//                Sys;
//                cout.println(getRandInt(0, selected.size()-1));
                one = selected.get(getRandInt(selected.size() - 1));
                two = selected.get(getRandInt(selected.size() - 1));
                repopulation.add(new Chromosome(one, two));
            }
            Chromosome c;
            for (int i = 0; i < populationSize; i++) {
                c = repopulation.get(i);
                population[i] = c;
            }
            cout.println("New Population is...");
            for (int i = 0; i < population.length; i++) {
                population[i].print();
                population[i].printFitness();
            }
//            break;
        }
    }

    private static int getRandInt(int max) {
        Random rand = new Random();
        max++;
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max));
        return randomNum;
    }
}
//        Chromosome n;
//        for (int i = 0; i < 3000; i++) {
//            n = new Chromosome();
//            if (n.getFitnessValue() == 1) {
//                n.print();
//                System.out.println("Atlast,,,at "+i+" iteration,"+n.getFitnessValue());
//                break;
//            }
//        }
