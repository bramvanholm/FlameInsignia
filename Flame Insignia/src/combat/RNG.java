package combat;

import java.util.Random;

public class RNG {

	//RNG: Random Number Generator
	//Generates a number between 0-100
	protected static int generateRN() {
		Random rand = new Random();
		int rn = rand.nextInt(101);
		return rn;	
	}
	
	//Calculating the Hit threshold
	//The Hit threshold is an average of 2 randomly generated numbers
	// BL: Got this from: https://serenesforest.net/general/true-hit/
	protected static int calculateHitThreshold(int n1, int n2) {
		int h = (n1+n2)/2;
		return h;
	}
	
	//BL: Just to test
	public static void main(String[] args) {
		int rn1 = generateRN();
		int rn2 = generateRN();
		int hitThreshold = calculateHitThreshold(rn1,rn2);
		
		System.out.println(rn1+" "+rn2+" "+hitThreshold);
		
	}
}
