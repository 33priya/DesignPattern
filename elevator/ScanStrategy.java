package elevator;

public class ScanStrategy implements ElevatorRequestScedulingStrategy {

	@Override
	public Request getNextMove() {
		return new Request();
	}
}
