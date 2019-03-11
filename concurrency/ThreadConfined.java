package concurrency;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadConfined {

	public static void main(String[] args) {
		System.out.println(formatDate(new Date()));
	}

	private static final ThreadLocal<DateFormat> tdf = new ThreadLocal<DateFormat>() {
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	
	public static String formatDate(Date date) {
		return tdf.get().format(date);
	}
}
