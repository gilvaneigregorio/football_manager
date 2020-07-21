package team;

import java.util.UUID;

import main.FootballManager;
import team.coach.Coach;

public class Team {
	
	private String id;
	private String name;

	private Coach coach;
	private Squad squad;
	
	public Team(String name, Coach coach, Squad squad) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.coach = coach;
		this.squad = squad;
		
		FootballManager.instance.setTeam(this);
	}
	
	public String getId() {
		return id;
	}
}
