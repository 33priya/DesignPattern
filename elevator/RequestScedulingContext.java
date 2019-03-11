package elevator;

public class RequestScedulingContext {

	private ElevatorRequestScedulingStrategy requestScedulingStrategy;

	public ElevatorRequestScedulingStrategy getRequestScedulingStrategy() {
		return requestScedulingStrategy;
	}

	public void setRequestScedulingStrategy(ElevatorRequestScedulingStrategy requestScedulingStrategy) {
		this.requestScedulingStrategy = requestScedulingStrategy;
	}
	
	public Request getNextRequestToProcess() {
		return requestScedulingStrategy.getNextMove();
	}
}
