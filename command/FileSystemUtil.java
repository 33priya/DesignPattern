package command;

public class FileSystemUtil {

	public static FileSystem getUnderlyingFileSystem() {
		String osName = System.getProperty("os.name");
		System.out.println("Underlying OS is:"+osName);
		if (osName.contains("Windows")) {
			return new WindowsFileSystem();
		} else {
			return new UnixFileSystem();
		}
	}

}
