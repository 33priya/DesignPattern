package concurrency;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestOutput {
	private static final ThreadLocalRandom tlr = ThreadLocalRandom.current();

	public boolean amIPretty() {
		return tlr.nextBoolean();
	}

	public static void main(String[] args) {
		final AtomicBoolean vanity = new AtomicBoolean(true);
		while (vanity.get()) {
			new Thread(new Runnable() {
				public void run() {
					TestOutput mirrorOnTheWall = new TestOutput();
					boolean beauty = mirrorOnTheWall.amIPretty();
					System.out.println("I am pretty - " + beauty);
					if (!beauty) {
						vanity.set(false);
					}
				}
			}).start();
		}
		System.out.println("I reached here!");
	}
}

