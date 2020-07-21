package team.Training;

public enum TrainingIntensity{    
	LIGHT(0), BALANCED(1), HIGH(2);
	
	private final int value;
	
	TrainingIntensity(int value){
        this.value = value;
    }
	
    public int getValue(){
        return value;
    }
    
    public float getImproveFactor() {
    	if (value == TrainingIntensity.LIGHT.getValue()) {
			return 0.1f;
		}
    	if (value == TrainingIntensity.BALANCED.getValue()) {
			return 0.25f;
		}
    	if (value == TrainingIntensity.HIGH.getValue()) {
			return 0.5f;
		}
    	
    	return 0;
    }
    
    public int getFadigueFactor() {
    	if (value == TrainingIntensity.LIGHT.getValue()) {
			return 1;
		}
    	if (value == TrainingIntensity.BALANCED.getValue()) {
			return 3;
		}
    	if (value == TrainingIntensity.HIGH.getValue()) {
			return 6;
		}
    	
    	return 0;
    }
}
