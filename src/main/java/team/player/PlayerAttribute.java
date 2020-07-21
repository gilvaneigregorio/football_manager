package team.player;

public class PlayerAttribute {
	
	public static int MINIMUM_ATTRIBUTE_VALUE = 0;
	public static int MAXIMUM_ATTRIBUTE_VALUE = 20;
	
	private float agility;
	private float strength;
	private float stamina;

	public PlayerAttribute(float agility, float strength, float stamina) {
		this.agility = agility;
		this.strength = strength;
		this.stamina = stamina;
	}
	
	public float getAgility() {
		return agility;
	}
	
	public void setAgility(float agility) {
		this.agility = agility;
	}
	
	public float getStrength() {
		return strength;
	}
	
	public void setStrength(float strength) {
		this.strength = strength;
	}
	
	
	public float getStamina() {
		return stamina;
	}
	
	public void setStamina(float stamina) {
		this.stamina = stamina;
	}
	
}
