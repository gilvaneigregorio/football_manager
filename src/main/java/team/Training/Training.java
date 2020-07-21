package team.Training;

import java.util.List;

import team.Squad;
import team.player.Player;

public class Training {
	
	private TrainingIntensity intensity;
	
	public Training() {
		// Default
		intensity = TrainingIntensity.BALANCED;
	}
	
	public void workout(Squad squad) {
		List<Player> playerList = squad.getPlayerList();
		
		for(Player p : playerList) {
			if(p.isAvalibleToPlayOrTraining()) {
				workout(p);
			}
		}
	}
	
	public void workout(Player player){
		float improveFactor = intensity.getImproveFactor();
		int fatigueFactor = intensity.getFadigueFactor();

		player.setAttributeImprove(improveFactor);
		player.setFatigue(fatigueFactor);
	}
}
