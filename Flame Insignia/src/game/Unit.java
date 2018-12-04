package game;

public abstract class Unit {
	//Defining unit variables
	//HP:/Health; HIT: Hit%; ATK: Attack; DEF: Defence; EVA: Evasion/dodge; MOV: Movement range
	private String NAME;
	private int HP;
	private int MAXHP;
	private int HIT;
	private int ATK;
	private int DEF;
	private int EVA;
	private int MOV;

	Unit(String name, int maxhp, int hit, int atk, int def, int mov) {
		this.NAME = name;
		this.HP = maxhp;
		this.MAXHP = maxhp;
		this.HIT = hit;
		this.ATK = atk;
		this.DEF = def;
		this.EVA = 0;
		this.MOV =mov;
	}

	public String getName() {
		return this.NAME;
	}
	public void setName(String name) {
		this.NAME = name;
	}
	public int getHP() {
		return this.HP;
	}
	public void setHP(int remaininghp) {
		this.HP=remaininghp;		
	}	
	public int getMAXHP() {
		return this.MAXHP;
	}
	public void setMAXHP(int maxhp) {
		this.MAXHP=maxhp;		
	}
	public String getInfo() {
		return this.getName() +"   HP "+ this.getHP()+"/"+this.getMAXHP();
		}
	
	//
	public int getHIT() {
		return this.HIT;
	}
	public void setHIT(int raisedhit) {
		this.HIT+=raisedhit;		
	}
	//
	public int getATK() {
		return this.ATK;
	}
	public void setATK(int raisedatk) {
		this.ATK+=raisedatk;	
	}
	//
	public int getDEF() {
		return this.DEF;
	}
	public void setDEF(int raiseddef) {
		this.DEF+=raiseddef;	
	}	
	//
	public int getEVA() {
		return this.EVA;
	}
	public void setEVA(int raisedEVA) {
		this.EVA=raisedEVA;	
	}
	public String getStats() {
		return "HIT " +this.getHIT()+ "   ATK " +this.getATK()+ "   DEF "+this.getDEF()+ "   EVA "+ this.getEVA();
	}
	//
	public int getMOV() {
		return this.MOV;
	}



	//Checks terrain unit is standing on and temporarily raises stats
	public void checkTerrain(String terrainName) {
		//use switches
		switch(terrainName) {
		case "Plain": this.setEVA(0);;
		break;

		case "Forest": this.setEVA(20);
		break;

		case "Tent": this.setEVA(30);
		break;
		
		case "Envoy": ;//Victory!
		break;
		}
	}
}
