package team.player;

import java.util.UUID;

import main.FootballManager;

public class Player {
	
	public static int MINIMUM_FATIGUE_VALUE = 0;
	public static int MAXIMUM_FATIGUE_VALUE = 100;

	private String id;
	private String name;
	private int age;
	private PlayerPosition position;
	
	private PlayerAttribute attribute;
	
	private PlayerMorale morale;
	private int injuredTime;
	
	private int fatigue;
	
	public Player(String name, int age, PlayerPosition position, PlayerAttribute attribute,
			PlayerMorale morale, int injuredTime, int fatigue) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.age = age;
		this.position = position;
		this.attribute = attribute;
		this.morale = morale;
		this.injuredTime = injuredTime;
		this.fatigue = fatigue;
		
		FootballManager.instance.setPlayer(this);
	}
	
	public String getId() {
		return id;
	}
	
	
	public void setAttributeImprove(float improveFactor) {
		attribute.setAgility(attribute.getAgility()+improveFactor);
		attribute.setStrength(attribute.getStrength()+improveFactor);
		attribute.setStamina(attribute.getStamina()+improveFactor);
	}
	
	public void setFatigue(int fatigueFactor) {
		fatigue -= fatigueFactor;
		if(fatigue < 0) {
			fatigue = 0;
		}
	}
	
	public boolean isAvalibleToPlayOrTraining() {
		if(morale == PlayerMorale.INJURED || morale == PlayerMorale.INJURED_BAD) {
			return false;
		}
		return true;
	}
	
}

