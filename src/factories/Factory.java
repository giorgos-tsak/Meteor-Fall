package factories;

public abstract class Factory {
	
	protected long currentTime,creationTime;
	protected double elapsedTime;
	
	public Factory() {
		currentTime =System.currentTimeMillis();
		creationTime = 0;
	}
	
	public abstract Creatable create();

}
