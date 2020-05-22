package engine;

public enum Preference
{
	LOVED(0.9),
	LIKED(0.95),
	DISLIKED(1.1),
	HATED(1.5);
	
	public double multiplicator;
	
	Preference(double multiplicator) {
		this.multiplicator = multiplicator;
	}
}
