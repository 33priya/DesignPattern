package concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.checkthread.annotations.ThreadConfined;
import org.checkthread.annotations.ThreadName;
import org.checkthread.annotations.ThreadSafe;

public abstract class ThreadSafeDemo {

	private final Map<String,String> map = new HashMap<String,String>();

	private volatile boolean flag = false;
	private final Object mutex = new Object();

	private ReentrantLock lock = null;

	public ThreadSafeDemo() {
		lock = new ReentrantLock();
	}

	@ThreadSafe
	public void put() {
		lock.lock();
		testSafety();
	}

	private void testSafety() {
		map.put("Priya", "Java Developer");
		lock.unlock();
	}

	@ThreadSafe
	public void m3() {
		synchronized (mutex) {
			flag = true;
			if(flag!=true) {
				m4();
			}
			flag = false;
		}
	}

	private void m4() {

	}

	/*@ThreadConfined(ThreadName.MAIN)
	public void m1() {
		System.out.println("this is thread " + Thread.currentThread().getName());
	}

	@ThreadConfined("t1")
	public void m2() {
		m1();
	}*/

	/*public static void main(String[] args) {
		ThreadSafeDemo o = new ThreadSafeDemo();

		Thread t1 = new Thread (()-> {
			try {
				System.out.println("this is thread " + Thread.currentThread().getName());
				Thread.sleep(1000);
				o.m2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.setName("t1");
		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("this is main end");
	}*/

}
