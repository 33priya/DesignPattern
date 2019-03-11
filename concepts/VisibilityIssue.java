package concepts;

public class VisibilityIssue {

	public static volatile int val;
	public static boolean isReady;

	private static class ReaderThread extends Thread {

		@Override
		public void run() {
			System.out.println("inside run: " + isReady);
			
			while (!isReady) {
				System.out.println(val);
				System.out.println("inside while: " + isReady);
				Thread.yield();
			}
			
			System.out.println(val);
		}
	}
	
	public static void main(String[] args) {
		
		VisibilityIssue.ReaderThread thread = new VisibilityIssue.ReaderThread();
		thread.start();
		val = 42;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {  
			e.printStackTrace();
		}
		
		isReady = true;
	}

}


