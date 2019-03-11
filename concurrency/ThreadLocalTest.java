package concurrency;

public class ThreadLocalTest {

	//volatile static Integer count = 0;
	
	public static void main(String[] args) {
	
//		Thread t1 = new Thread(new Worker1(count));
		Thread t2 = new Thread(new Worker2());
		Thread t3 = new Thread(new Worker2());
		//Worker2 t4 = new Worker2();
		
		//ThreadLocal<Worker2> threadLocal = new ThreadLocal<>();
		try {
			//threadLocal.set(t4);
//		t1.start();
		t2.start();

//		Thread.sleep(1000);
		System.out.println("I am in main thread " + new VolatileVariableHolder().count);
		t3.start();
		
			t3.join();
			t2.join();
			System.out.println("I am in main thread " + new VolatileVariableHolder().count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}

/*class Worker1 implements Runnable {
	Integer count;
	ThreadLocal<Integer> tl = new ThreadLocal<>();
	public Worker1(Integer count) {
		this.count = count;
		tl.set(count);
	}
	
	@Override
	public void run() {
		try {
			tl.set(++count);
			System.out.println("I am in thread 1: " + tl.get());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}*/

class VolatileVariableHolder {
	volatile Integer count = 0;
}

class Worker2 implements Runnable {
	VolatileVariableHolder helper = null;
	
	public Worker2() {
		helper = new VolatileVariableHolder();
	}
	
	@Override
	public void run() {
		try {
			ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
			threadLocal.set(helper.count);
			System.out.println("Before increment thread local value: " + threadLocal.get() + " for thread :" + Thread.currentThread().getName());
			
			System.out.println("Before increment value: " + helper.count + " for thread :" + Thread.currentThread().getName());
			increment();
			Thread.sleep(1000);
			System.out.println("After increment value: " + helper.count + " for thread :" + Thread.currentThread().getName());
			
			System.out.println("After increment thread local value: " + threadLocal.get() + " for thread :" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void increment() {
		helper.count++;
	}
}
