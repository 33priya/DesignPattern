package command;

public class OpenFileCommand implements Commond {

	private FileSystem fileSystem;
	
	OpenFileCommand(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}
	
	@Override
	public void execute() {
		fileSystem.open();
	}

}