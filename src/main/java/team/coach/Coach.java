package team.coach;

import java.util.UUID;

import main.FootballManager;
import team.Training.Training;

public class Coach {
	
	private String id;
	private String name;
	private int age;
	private CoachBehavior behaviour;
	private Training training;
	
	public Coach(String name, int age, CoachBehavior behaviour) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.age = age;
		this.behaviour = behaviour;
		this.training = new Training();
		
		FootballManager.instance.setCoach(this);
	}
	
	public String getId() {
		return id;
	}
}
