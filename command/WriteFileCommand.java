package command;

public class WriteFileCommand implements Commond {

	private FileSystem fileSystem;
	
	WriteFileCommand(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}
	
	@Override
	public void execute() {
		fileSystem.write();
	}

}
