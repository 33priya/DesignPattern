package concurrency;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StackConfined {

	public static void main(String[] args) {
		System.out.println(formatDate(new Date()));
	}

	public static String formatDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
}
