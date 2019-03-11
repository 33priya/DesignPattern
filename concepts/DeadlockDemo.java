package concepts;

public class DeadlockDemo {
	private final static Object lock1 = new Object();
	private final static Object lock2 = new Object();
	
	public static void main(String[] args) {
		//Deadlock Situation 1
		/*Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(lock1) {
					try {
						System.out.println("Holding Lock 1");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("Requesting Lock 2");
					synchronized(lock2) {
						System.out.println("Holding Lock 1 & 2");
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(lock2) {
					try {
						System.out.println("Holding Lock 2");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Requesting Lock 1");
					synchronized(lock1) {
						System.out.println("Holding Lock 2 & 1");
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		
		//Deadlock Resolution
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(lock1) {
					try {
						System.out.println("Holding Lock 1");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("Requesting Lock 2");
					synchronized(lock2) {
						System.out.println("Holding Lock 1 & 2");
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized(lock1) {
					try {
						System.out.println("Holding Lock 1");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Requesting Lock 2");
					synchronized(lock2) {
						System.out.println("Holding Lock 1 & 2");
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		*/
		
		//Deadlock Situation 2 if intrinsic locks were not reentrant 
		LoggingWidget lw = new LoggingWidget();
		lw.foo();
	}
}

class Widget {
	public synchronized void foo() {
		System.out.println("Widget foo");
	}
}

class LoggingWidget extends Widget {
	public synchronized void foo() {
		System.out.println("LoggingWidget foo");
		super.foo();
	}
}
