package elevator;

public class ShortestSeekFirstStrategy implements ElevatorRequestScedulingStrategy {

	@Override
	public Request getNextMove() {
		return new Request();
	}
	
}
