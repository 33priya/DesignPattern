package mediator;

public class UserImpl extends User {

	UserImpl(Mediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void send(String message) {
		System.out.println(this.name + ": Sending Message= " + message);
		mediator.sendMessage(message, this);
	}

	@Override
	public void receive(String message) {
		System.out.println(this.name + ": Received Message: "+ message);
	}

}
