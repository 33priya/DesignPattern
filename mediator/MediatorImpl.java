package mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorImpl implements Mediator {
	private List<User> users;
	
	MediatorImpl() {
		this.users = new ArrayList<>();
	}
	
	@Override
	public void sendMessage(String message, User user) {
		for (User inputUser : users) {
			if (inputUser != user) {
				inputUser.receive(message);
			}
		}
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}

}
