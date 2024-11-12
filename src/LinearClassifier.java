public class LinearClassifier {

    static double[][] points = {
            {3, 3, 0}, {3, 5, 0}, {3, 18, 0}, {7, 15, 0}, {18, 18, 0}, {0, 0, 0},
            {43, 18, 0}, {-18, -1, 0}, {3, 3, 0}, {4, -1, 1}, {4, -5, 1}, {2, -5, 1},
            {10, -16, 1}, {-20, -40, 1}, {4, 4, 1},
            {1, 1, 0}, {1, 2, 0}, {3, 3, 0}, {4, 1, 1}, {5, 2, 1}, {4, 1, 1}, {6, 6, 1}
    };

    static double m = 1.0; // Initial slope
    static double b = 0.0; // Initial intercept

    public static void main(String[] args) {
        printData();
        testPredictions();
    }

    private static void testPredictions() {
        for (double[] point : points) {
            double x = point[0];
            double y = point[1];
            int actualCategory = (int) point[2];
            int predictedCategory = predict(x, y);
            System.out.println("Point (" + x + ", " + y + ") - Actual: "
                    + actualCategory + ", Predicted: " + predictedCategory);
        }
    }

    private static int predict(double x, double y) {
        double lineY = m * x + b;
        return (y > lineY) ? 1 : 0;
    }

    public static void printData() {
        for (double[] point : points) {
            double x = point[0];
            double y = point[1];
            int category = (int) point[2];
            System.out.println("Point (" + x + ", " + y + ") - Category: " + category);
        }
    }
}
