package unitStats;

public class Enemy extends Unit {
	
	//BL: enum? (Exercise 3 Chapter 5)
	//Adding and assigning values to superclass variables
	
	Enemy() {
		this(15,75,10,7, 4);
	}
	// for Boss
	Enemy(int hp, int hit, int atk, int def, int mov) {
		super.HP = hp;
		super.HIT = hit;
		super.ATK = atk;
		super.DEF = def;
		super.EVA = 0;
		super.MOV = mov;	
	}
	static Enemy bandit1 = new Enemy();
	static Enemy boss = new Enemy(30,80,12,9,0);
	
	//BL: Just a test
	public static void main(String[] args) {
	
	System.out.println(boss.MOV);
	}
}
