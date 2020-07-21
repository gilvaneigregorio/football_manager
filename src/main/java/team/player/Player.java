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
	
	public int getGameScore(){
		int positionScore = 0;
		
		if(position == PlayerPosition.GOALKEEPER) {
			positionScore = (int) ((attribute.getAgility()+attribute.getStrength()+attribute.getStamina())/3);
		}
		if(position == PlayerPosition.CENTER_DEFENSIVE_MIDFIELDER) {
			positionScore = (int) ((attribute.getAgility() + attribute.getStrength()*3 + attribute.getStamina()*2)/6);
		}
		if(position == PlayerPosition.SIDE_BACK) {
			positionScore = (int) ((attribute.getAgility()*2 + attribute.getStrength() + attribute.getStamina()*3)/6);
		}
		if(position == PlayerPosition.CENTER_DEFENSIVE_MIDFIELDER) {
			positionScore = (int) ((attribute.getAgility() + attribute.getStrength()*2 + attribute.getStamina()*2)/5);
		}
		if(position == PlayerPosition.CENTER_ATTACKING_MIDFIELDER) {
			positionScore = (int) ((attribute.getAgility()*2 + attribute.getStrength()*2 + attribute.getStamina())/5);
		}
		if(position == PlayerPosition.WING) {
			positionScore = (int) ((attribute.getAgility()*3 +attribute.getStrength() + attribute.getStamina())/5);
		}
		if(position == PlayerPosition.STRIKER) {
			positionScore = (int) ((attribute.getAgility()*3 + attribute.getStrength()*2 + attribute.getStamina())/6);
		}

		int fatigueScore = (positionScore*(fatigue+(MAXIMUM_FATIGUE_VALUE-fatigue)/2)/MAXIMUM_FATIGUE_VALUE);
		
		int moraleScore = 0;
		if(morale == PlayerMorale.HORRIBLE) {
			moraleScore = (int) (positionScore*0.5f);
		}
		if(morale == PlayerMorale.BAD) {
			moraleScore = (int) (positionScore*0.75f);
		}
		if(morale == PlayerMorale.OK) {
			moraleScore = (int) (positionScore*1f);
		}
		if(morale == PlayerMorale.GOOD) {
			moraleScore = (int) (positionScore*1.25f);
		}
		if(morale == PlayerMorale.EXCELENT) {
			moraleScore = (int) (positionScore*1.5f);
		}
		
		return (positionScore+fatigueScore+moraleScore)/3;
	}
	
}

