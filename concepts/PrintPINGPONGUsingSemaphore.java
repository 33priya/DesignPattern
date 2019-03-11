package concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintPINGPONGUsingSemaphore {
	public static void main(String[] args) {
		PrintMessage pm = new PrintMessage();
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new Ping(pm)); 
		service.execute(new Pong(pm)); 
		
	}
}

class Ping implements Runnable {
	private PrintMessage pm;
	
	Ping (PrintMessage pm) {
		this.pm = pm;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			pm.printPing();
		}
	}
}

class Pong implements Runnable {
	private PrintMessage pm;
	
	Pong(PrintMessage pm) {
		this.pm = pm;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			pm.printPong();
		}
	}
}

class PrintMessage {
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition ping = lock.newCondition();
	private final Condition pong = lock.newCondition();
	
	public void printPing() {
		try {
			lock.lock();
			pong.await();
			System.out.println("PING");
			pong.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void printPong() {
		try {
			lock.lock();
			ping.await();
			System.out.println("PONG");
			ping.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
