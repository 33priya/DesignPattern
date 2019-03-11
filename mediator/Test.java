package mediator;

public class Test {

	public static void main(String[] args) {

		Mediator mediator = new MediatorImpl();
		User user1 = new UserImpl(mediator, "Priya");
		User user2 = new UserImpl(mediator, "Riya");
		User user3 = new UserImpl(mediator, "Jyoti");
		User user4 = new UserImpl(mediator, "Renu");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		
		user1.send("Hi All");
	}

}
