package mediator;

public interface Mediator {
	public void sendMessage(String message, User user);
	public void addUser(User user);
}
