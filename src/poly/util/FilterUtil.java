package poly.util;

public class FilterUtil {
	public static String revertXSS(String value) {
    	value = value.replaceAll("& lt;", "<").replaceAll("& gt;", ">");
        value = value.replaceAll("& #40;", "(").replaceAll("& #41;", ")");
        value = value.replaceAll("& #39;", "'");
        value = value.replaceAll("scr!pt", "script");
        return value;
    }
}
