package concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonPattern { 

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; ++i) {
			service.execute(new MyRunnable(i+1));
		}
		
		service.shutdown();
	}
}

class MyRunnable implements Runnable {
	private int id;
	
	public MyRunnable(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread " + id);
			Thread.sleep(2000);
			initializeInstance();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void initializeInstance() {
		SingletonClass instance = SingletonClass.getInstance();
		System.out.println(instance);
	}
}

class SingletonClass {
	private volatile static SingletonClass INSTANCE = null;
	
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		if (INSTANCE == null) {
			synchronized(SingletonClass.class) {
				if (INSTANCE == null) {
					INSTANCE = new SingletonClass();
				}
			}
		}
		return INSTANCE;
	}
}

enum SingletonEnum {
	INSTANCE
}
