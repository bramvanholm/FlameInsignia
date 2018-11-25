package unitStats;

public abstract class Unit {
	//Defining unit variables
	//HP: Hit Points/Health; HIT: Hit%; ATK: Attack; DEF: Defence; EVA: Evasion/dodge; MOV: Movement range
	private int HP;
	private int HIT;
	private int ATK;
	private int DEF;
	private int EVA;
	private int MOV;

	Unit(int hp, int hit, int atk, int def, int mov) {
		this.HP = hp;
		this.HIT = hit;
		this.ATK = atk;
		this.DEF = def;
		this.EVA = 0;
		this.MOV =mov;
	}

	public int getHP() {
		return this.HP;
	}
	public void setHP(int remaininghp) {
		this.HP=remaininghp;		
	}
	//
	public int getHIT() {
		return this.HIT;
	}
	public void setHIT(int raisedhit) {
		this.HP=raisedhit;		
	}
	//
	public int getATK() {
		return this.ATK;
	}
	public void setATK(int raisedatk) {
		this.ATK=raisedatk;	
	}
	//
	public int getDEF() {
		return this.DEF;
	}
	public void setDEF(int raiseddef) {
		this.ATK=raiseddef;	
	}
	//
	public int getEVA() {
		return this.EVA;
	}
	public void setEVA(int raisedEVA) {
		this.HP=raisedEVA;	
	}
	//
	public int getMOV() {
		return this.MOV;
	}
	

	
	//Checks terrain unit is standing on and temporarily raises stats
	public void checkTerrain() {
		//use switches
	}
}
