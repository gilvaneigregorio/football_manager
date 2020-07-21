package team.coach;

public enum CoachBehavior {    
	DEFENSIVE(0), BALANCED(1), SITUATIONAL(2), OFFENSIVE(3);
	
	private final int value;
	
	CoachBehavior(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}

