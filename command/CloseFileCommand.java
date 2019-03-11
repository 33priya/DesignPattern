package command;

public class CloseFileCommand implements Commond {

	private FileSystem fileSystem;
	
	CloseFileCommand(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}
	
	@Override
	public void execute() {
		fileSystem.close();
	}

}
