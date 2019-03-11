package concepts;
import org.checkthread.annotations.ThreadSafe;
//@ThreadSafe
public class Point {
	private final int x;

	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public Point translate(int dx, int dy) {
		return new Point(x + dx, y + dy);
	}
}
