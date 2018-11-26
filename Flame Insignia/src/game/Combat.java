package game;

import java.util.Random;

public class Combat {

	//BL: "import" this.Ally + this.Enemy; Via GameGUI
	public int calculateHit(int hit, int eva) {
		int trueHit = hit - eva;
		return trueHit;
	}
	
	//BL: For real-time Calculating damage/Hit take a look at Exercise 4 Chapter 4

	public static int calculateDamage(int atk, int def, int hp) {
	int damage = atk - def;
	int remainingHP = hp - damage;
	return remainingHP;
	}
	
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
	
	
	//BL: Combat Calculations: Successful hit + damage
	public void performCombat(Unit Ally, Unit Enemy) {
		
		//Hit + damage of Ally unit
		if (Unit instanceof Ally) { //BL: Or if (turn =="Allies")
			int rn1 = generateRN();
			int rn2 = generateRN();
			int hitThreshold = calculateHitThreshold(rn1,rn2);
			int trueHitAlly = calculateHit(Ally.getHIT(),Enemy.getEVA());

			if (trueHitAlly > hitThreshold) {
				//BL: with set.*?
				int remaininghp = calculateDamage(Ally.getATK(),Enemy.getDEF(), Enemy.getHP());
				Enemy.setHP(remaininghp);
				
			// Attack misses	
			} else {
				 //BL: No action = return void/null?
			}
			//BL: pop-up message with Ally and Enemy health
			
		//Hit + damage of Enemy unit
		} else {
			int rn1 = generateRN();
			int rn2 = generateRN();
			int hitThreshold = calculateHitThreshold(rn1,rn2);
			int trueHitEnemy = calculateHit(Enemy.getHIT(),Ally.getEVA());

			if (trueHitEnemy > hitThreshold) {
				//BL: with set.*?
				int remaininghp = calculateDamage(Ally.getATK(), Enemy.getDEF(), Enemy.getHP());
				Enemy.setHP(remaininghp);
				
			//Attack misses	
			} else {
				//BL: No action= return void/null?
			}
		}
		//BL: EXP?
		//BL: message pop-up: #HP of each Unit left after battle
	}
}