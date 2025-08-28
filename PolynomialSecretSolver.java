import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PolynomialSecretSolver {

    // Class to hold a point (x,y)
    static class Point {
        int x;
        BigInteger y;  // Use BigInteger for large values

        Point(int x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }

    // Decode the y value string from the given base as BigInteger
    static BigInteger decodeValue(String encoded, int base) {
        return new BigInteger(encoded, base);
    }

    // Lagrange interpolation using double precision for calculations
    static double interpolate(Point[] points, int xi) {
        double result = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            double term = points[i].y.doubleValue();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= ((double)(xi - points[j].x)) / (points[i].x - points[j].x);
                }
            }
            result += term;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("input.json");
        JSONObject json = new JSONObject(new JSONTokener(reader));
        JSONObject keys = json.getJSONObject("keys");

        int n = keys.getInt("n");
        int k = keys.getInt("k");

        List<Point> pointsList = new ArrayList<>();

        for (String key : json.keySet()) {
            if (key.equals("keys")) continue;

            int x = Integer.parseInt(key);
            JSONObject entry = json.getJSONObject(key);

            int base = Integer.parseInt(entry.getString("base"));
            String valueStr = entry.getString("value");

            BigInteger y = decodeValue(valueStr, base);
            pointsList.add(new Point(x, y));
        }

        pointsList.sort(Comparator.comparingInt(p -> p.x));

        Point[] points = pointsList.subList(0, k).toArray(new Point[0]);

        double secretC = interpolate(points, 0);

        System.out.println("The value of c (constant term) is: " + Math.round(secretC));
    }
}
