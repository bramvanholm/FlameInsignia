package game;

public class Enemy extends Unit {
	
	//BL: enum? (Exercise 3 Chapter 5)
	//Adding and assigning values to superclass variables
	
	Enemy(String name, int hp, int hit, int atk, int def) {
		super(name,hp,hit,atk,def,4);
	}
	// for Boss
	Enemy(String name, int hp, int hit, int atk, int def, int mov) {
		super(name,hp,hit,atk,def,mov);
	}

	
	
	//BL: Just a test
	public static void main(String[] args) {
		Enemy bandit1 = new Enemy("Bandit",15,70,7,6);
		Enemy boss = new Enemy("Boss",30,80,12,9,0);
	System.out.println(boss.getMOV());
	}
}

