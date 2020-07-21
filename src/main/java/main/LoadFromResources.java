package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

import team.Squad;
import team.Team;
import team.coach.Coach;
import team.coach.CoachBehavior;
import team.player.Player;
import team.player.PlayerAttribute;
import team.player.PlayerMorale;
import team.player.PlayerPosition;

public class LoadFromResources {
	
	public static Team loadTeam(String filePath) throws IOException {
		InputStream is = LoadFromResources.class.getResourceAsStream(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		StringBuilder sb = new StringBuilder();
	    String line;
	    br = new BufferedReader(new InputStreamReader(is));
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
	    
	    JSONObject json = new JSONObject(sb.toString());

		String name = json.getString("name");
		Coach coach = loadCoach(json.getJSONObject("coach"));
		Squad squad = loadSquad(json.getJSONArray("players"));
	
		return new Team(name, coach, squad);
	}
	
	private static Coach loadCoach(JSONObject json) {
		String name = json.getString("name");
		int age = json.getInt("age");
		CoachBehavior behaviour = CoachBehavior.valueOf(json.getString("behaviour"));
		return new Coach(name, age, behaviour);
	}

	private static Squad loadSquad(JSONArray jsonArray) {
		LinkedList<Player> players = new LinkedList<Player>();
		for(int i=0; i<jsonArray.length(); i++) {
			players.add(loadPlayer(jsonArray.getJSONObject(0)));
		}
		
		return new Squad(players);
	}
	
	private static Player loadPlayer(JSONObject json) {
		String name = json.getString("name");
		int age = json.getInt("age");
		PlayerPosition position = PlayerPosition.valueOf(json.getString("position"));
		PlayerAttribute attribute = new PlayerAttribute(json.getInt("agility"), json.getInt("strength"), json.getInt("stamina"));
		PlayerMorale morale = PlayerMorale.GOOD;
		int injuredTime = 0;
		int fatigue = Player.MAXIMUM_FATIGUE_VALUE;
		
		return new Player(name, age, position, attribute, morale, injuredTime, fatigue);
	}
}
