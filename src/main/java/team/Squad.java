package team;

import java.util.List;

import team.player.Player;

public class Squad {
	
	public static int NUMBER_PLAYERS_LIMIT = 22;
	
	private List<Player> playerList;
	
	public Squad(List<Player> playerList) {
		this.playerList = playerList;
	}
	
	public List<Player> getPlayerList() {
		return playerList;
	}

}