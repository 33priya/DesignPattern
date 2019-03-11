package command;

public class FileInvoker {

	private Commond commond;
	
	FileInvoker(Commond commond) {
		this.commond = commond;
	}
	
	public void execute() {
		commond.execute();
	}

}
