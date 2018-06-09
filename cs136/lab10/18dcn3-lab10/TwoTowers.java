/** @author Dan Needham
 * A class for solving the two towers problem. Uses all possible subsets of blocks 
 * and compares the sum of the square roots of each of its blocks 
 * to the total height of blocks divided by 2. 
 * Returns the two subsets that represents two towers of blocks closest to equal
 * heights. 
 */
import structure5.*;
    
public class TwoTowers{

    //The vector containing the areas of each of the given blocks in the problem.
    private Vector<Double> vec;
    //The height of all the blocks.
    private Double h;
    //Number of blocks.
    private int n;
    
    public TwoTowers(int n){
	vec = new Vector<Double>();
	for(Double i=1.0;i<=n;i++){
	    vec.add(i);
	}
	h = 0.0;
	for (Double item : vec){
	    h += Math.sqrt(item);
	}
	h /= 2.0;    
    }
    /**
     * Runs a simulation that:
     * 1. Finds every subset of the vector of blocks.
     * 2. Measures the height of each subset as the sum of the squares of each block. 
     * 3. Compares the height to the total height/2 and returns the subset that is closest but does not exceed h/2 and its complement. 
     */
    public static void main(String[] args){
	TwoTowers sim = new TwoTowers(25);
      	System.out.println("Vector of all blocks: " + sim.vec.toString());
	System.out.println("Target height of each tower: " + sim.h);

	SubsetIterator<Double> solutions = new SubsetIterator<Double>(sim.vec);

	Vector<Double> solution = new Vector<Double>();
	Double solutionHeight = 0.0;    
	while (solutions.hasNext()){

	    Double tempHeight = 0.0;
	    Vector<Double> temp = solutions.next();
	    for (Double item : temp){
		tempHeight += Math.sqrt(item);
	    }
	    if (solutionHeight < tempHeight && tempHeight < sim.h){
		solutionHeight = tempHeight;
		solution = temp;
	    }
	}

	System.out.println("Tower number one consists of blocks: " + solution);
	System.out.println("Height = " + solutionHeight);
	Vector<Double> copy = sim.vec;
	for (Double item : solution){
	    copy.remove(item);
	}
	Double copyHeight = 0.0;
	for (Double item : copy){
	    copyHeight += Math.sqrt(item);
	}
	System.out.println("Tower number two consists of blocks: " + copy);
	System.out.println("Height = " + copyHeight);
    }
}
		    

