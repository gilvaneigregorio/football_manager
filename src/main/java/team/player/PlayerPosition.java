package team.player;

public enum PlayerPosition {    
	GOALKEEPER(0), CENTER_BACK(1), SIDE_BACK(2), CENTER_DEFENSIVE_MIDFIELDER(3), CENTER_ATTACKING_MIDFIELDER(4), WING(5), STRIKER(6);
	
	private final int value;
	
	PlayerPosition(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}