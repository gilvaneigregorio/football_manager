package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

import team.Team;
import team.coach.Coach;
import team.player.Player;

public class FootballManager {
	
	public static FootballManager instance;
	
	private Hashtable<String, Team> teamHash;
	private Hashtable<String, Player> playerHash;
	private Hashtable<String, Coach> coachHash;
	
	public FootballManager() {
		instance = this;
		
		teamHash = new Hashtable<String, Team>();
		playerHash = new Hashtable<String, Player>();
		coachHash = new Hashtable<String, Coach>();
		
		loadTeamFromResources();
	}

	public Team getTeam(String teamId) {
		return teamHash.get(teamId);
	}
	
	public void setTeam(Team team) {
		teamHash.put(team.getId(), team);
	}
	
	public Player getPlayer(String playerId) {
		return playerHash.get(playerId);
	}
	
	public void setPlayer(Player player) {
		playerHash.put(player.getId(), player);
	}
	
	public Coach getCoach(String coachId) {
		return coachHash.get(coachId);
	}
	
	public void setCoach(Coach coach) {
		coachHash.put(coach.getId(), coach);
	}
	
	private void loadTeamFromResources() {
		try {
			InputStream is = LoadFromResources.class.getResourceAsStream("/");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(".json")) {
					Team team = LoadFromResources.loadTeam("/"+line);
					System.err.println(team.getId());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
