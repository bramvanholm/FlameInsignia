package unitStats;

public class Ally extends Unit {
	
	//BL: enum? (Exercise 3 Chapter 5)
	//Adding and assigning values to superclass variables
	Ally(int hp) {
		this(hp,75,10,7);
	}
	//For Prince
	Ally(int hp, int hit, int atk, int def) {
		super.HP = hp;
		super.HIT = hit;
		super.ATK = atk;
		super.DEF = def;
		super.EVA = 0;
		super.MOV = 5;
		final int EXP = 0;
	}
	// How to make(/initialize?) units? => UnitPlacer?
	static Ally prince = new Ally(20,80,11,8); 
	//BL: For prince: Insert/increase stats from choice star screen
	static Ally retainer = new Ally(20);
	static Ally guard = new Ally(25);
			
	//BL: Just a test
	public static void main(String[] args) {
	
	System.out.println(prince.HIT);
	}
	
	
}