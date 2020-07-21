package team.player;

public enum PlayerMorale {    
	HORRIBLE(0), BAD(1), OK(2), GOOD(3), EXCELENT(4), INJURED(5), INJURED_BAD(6);
	
	private final int value;
	
	PlayerMorale(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
