package concepts;

import java.util.concurrent.TimeUnit;

public class StopThreadFromAnotherThread {
	private static boolean stopRequested = false;
	
	public static synchronized boolean isStopRequested() {
		return stopRequested;
	}

	public static synchronized void setStopRequested() {
		stopRequested = true;
	}

	public static void main(String[] args) {
		Thread t = new Thread(()-> {
			int i = 0;
			while (!isStopRequested()) {
				++i;
				System.out.println(i);
				}
			});
		
		t.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setStopRequested();
	}

}
