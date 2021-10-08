import java.util.Locale;

public class Me
{
    private static String OS = System.getProperty("os.name", "unknown").toLowerCase(Locale.ROOT);
    public static void main(String[] args) {
    	System.out.println(OS);
    }
}