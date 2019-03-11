package command;

public class UnixFileSystem implements FileSystem {
	
	@Override
	public void open() {
		System.out.println("Opening file in unix OS");
	}

	@Override
	public void write() {
		System.out.println("Writing file in unix OS");
	}

	@Override
	public void close() {
		System.out.println("Closing file in unix OS");
	}

}