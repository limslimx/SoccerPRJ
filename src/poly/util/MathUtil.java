package poly.util;

import java.util.List;

public class MathUtil {
	public static double stdDev(List<Float> numArray)
    {
        float sum = 0.0f, standardDeviation = 0.0f;
        int length = numArray.size();
        for(float num : numArray) {
            sum += num;
        }
        float mean = sum/length;
        for(float num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation/length);
    }
}
