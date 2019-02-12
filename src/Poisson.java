import java.util.Arrays;

public class Poisson {
	
	//Attributes
	
	private int[] squares;
	private double average, totalCampers, totalSquares;
	private double[] observedProb, poissonProb, poissonFreq;
	
	//Constructors
	
	public Poisson(int[] squares) {
		this.squares = squares;
		getAverage();
		getProb();
		getPoisson();
		
		System.out.println("The average campers per plot is "+ average);
		System.out.println("The observed probabilites are: "+ Arrays.toString(observedProb));
		System.out.println("The observed frequency is "+ Arrays.toString(squares));
		System.out.println();
		System.out.println("The Poisson Probabiliy is " + Arrays.toString(poissonProb));
		System.out.println("The Poisson Frequency is " + Arrays.toString(poissonFreq));
	}
	
	//Methods
	
	private double getAverage() {
		totalCampers = 0;
		totalSquares = 0;
		
		for (int i = 0; i < squares.length; i++) {
			totalCampers += squares[i] * i;
			totalSquares += squares[i];
		}
		
		average = totalCampers / totalSquares;	
		return average;
	}
	
	private double[] getProb() {
		
		observedProb = new double[squares.length];
		
		for (int i = 0; i < observedProb.length; i++) {
			observedProb[i] = squares[i] /totalSquares;
		}
		
		return observedProb ;
	}
	
	private double[] getPoisson() {
		poissonProb = new double[squares.length];
		poissonFreq = new double[squares.length];
		
		for (int i = 0; i < poissonProb.length; i++) {
			poissonProb[i] = Math.pow(average, i) /(factorial(i) * Math.exp(average));
		    poissonFreq[i] = poissonProb[i] * totalSquares;
		}
		
		return poissonProb;
		
	}
	
	private double factorial(int n) {
		
		int factor = 1;
		
		for (int i = n; i > 0; i--) {
			factor *= i;
		}
		
		return factor;
	}
	

	
	

}
