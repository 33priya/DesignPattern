package concurrency;

import java.util.concurrent.CountDownLatch;

public class APIPerformanceTestUsingLatch {

	public static void main(String[] args) {
		try {
			timeTask(1000, new MyAPITester());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static long timeTask(int noOfThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(noOfThreads);
		
		for (int i = 0; i < noOfThreads; ++i) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						startGate.await();
						//Hit API
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ie) {}
				}
			});
			
			t.start();
		}
		
		long startTime = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long endTime = System.nanoTime();
		return endTime-startTime;
	}
}

class MyAPITester implements Runnable {
	@Override
	public void run() {
		//do stuff related to API call
	}
}
