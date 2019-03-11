package concepts;

import java.util.concurrent.Semaphore;

public class PrintOddEvenUsingSemaphore {
	
	public static void main(String[] args) {
		Printer printer = new Printer();
		
		Thread odd = new Thread(new Odd(10, printer));
		Thread even = new Thread(new Even(10, printer));
		
		odd.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		even.start();
	}
}

class Odd implements Runnable {
	private int num;
	private Printer printer;
	
	Odd (int num, Printer printer) {
		this.num = num;
		this.printer = printer;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < num; i = i + 1) {
			printer.printOdd(i);
		}
	}
}

class Even implements Runnable {
	private int num;
	private Printer printer;
	
	Even (int num, Printer printer) {
		this.num = num;
		this.printer = printer;
	}
	
	@Override
	public void run() {
		for (int i = 2; i < num; i = i + 2) {
			printer.printEven(i);
		}
	}
}

class Printer {
	Semaphore odd = new Semaphore(1);
	Semaphore even = new Semaphore(0);
	
	public void printOdd(int num) {
		try {
			odd.acquire();
			System.out.println(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			even.release();
		}
	}

	public void printEven(int num) {
		try {
			even.acquire();
			System.out.println(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			odd.release();
		}
	}
}
