/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga.siment;

/**
 *
 * @author hasaan
 */
public class GASiment {

    private static final Chromosome[] population = new Chromosome[10];

    public static void main(String[] args) {

        //generate population , evaluate
        for (int i = 0; i < population.length; i++) {
            population[i] = new Chromosome();
            population[i].print();
            population[i].printFitness();
        }

        int iterations = 1000;
        for (int iterNo = 0; iterNo < iterations; iterNo++) {
        //selection
            for (int i = 0; i < population.length; i++) {
                if(population[i].getFitnessValue()>0.5);
            }
        //repopulate and evaluate
            
        }
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
