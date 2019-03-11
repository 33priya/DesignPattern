package concurrency;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InterruptionTest {

	public static void main(String[] args) {
		try {
			consumePrimes();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static int count;

	static void consumePrimes() throws InterruptedException {
		BlockingQueue<BigInteger> queue = new LinkedBlockingQueue<>();
		BrokenPrimeProducer producer = new BrokenPrimeProducer(queue);
		producer.start();
		try {
			while(needMorePrime()) {
				queue.take();
			}
		} finally {
			producer.cancel();
		}
	}

	private static boolean needMorePrime() {
		if (count == 10) return true;
		++count;
		return false;
	}
}

class BrokenPrimeProducer extends Thread {
	private final BlockingQueue<BigInteger> queue;
	private volatile boolean cancelled = false;
	
	BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			BigInteger p = BigInteger.ONE;
			while (!cancelled) {
				queue.put(p = p.nextProbablePrime());
			}
		} catch (InterruptedException consumed) {}
	}
	
	/**
	 * unreliable cancellation that can leave producer stuck in blocking operation.
	 */
	public void cancel() {
		cancelled = true;
	}
}

class PrimeGenerator extends Thread {
	private final BlockingQueue<BigInteger> queue;
	
	PrimeGenerator(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			BigInteger p = BigInteger.ONE;
			while (!Thread.currentThread().isInterrupted()) {
				queue.put(p = p.nextProbablePrime());
			}
		} catch (InterruptedException consumed) {}
	}
	
	/**
	 * Using Interruption for thread cancellation.
	 */
	public void cancel() {
		interrupt();
	}
}