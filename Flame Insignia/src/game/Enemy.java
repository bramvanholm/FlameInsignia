package game;

public class Enemy extends Unit {

	//BL: enum? (Exercise 3 Chapter 5)
	//Adding and assigning values to superclass variables

	public Enemy(String name, int maxhp, int hit, int atk, int def) {
		super(name,maxhp,hit,atk,def,4);
	}
	// for Boss
	public Enemy(String name, int maxhp, int hit, int atk, int def, int mov) {
		super(name,maxhp,hit,atk,def,mov);
	}



	//BL: Just a test
	public static void main(String[] args) {
		Enemy bandit1 = new Enemy("Bandit",15,70,7,6);
		Enemy boss = new Enemy("Boss",30,80,12,9,0);
		System.out.println(boss.getHP());
	}
}

