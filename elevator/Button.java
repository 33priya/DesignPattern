package elevator;

public abstract class Button {
	
	public void illuminate() {
		System.out.println("Button is pressed");
	}
	
	public void doNotIlluminate() {
		System.out.println("Button is not pressed");
	}
	
	public abstract void placeRequest();
}
