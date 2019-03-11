package command;

public class WindowsFileSystem implements FileSystem {
	
	@Override
	public void open() {
		System.out.println("Opening file in Windows OS");
	}

	@Override
	public void write() {
		System.out.println("Writing file in Windows OS");
	}

	@Override
	public void close() {
		System.out.println("Closing file in Windows OS");
	}

}
