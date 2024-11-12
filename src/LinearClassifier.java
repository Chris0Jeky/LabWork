public class LinearClassifier {

    static double[][] points = {
            {3, 3, 0}, {3, 5, 0}, {3, 18, 0}, {7, 15, 0}, {18, 18, 0}, {0, 0, 0},
            {43, 18, 0}, {-18, -1, 0}, {3, 3, 0}, {4, -1, 1}, {4, -5, 1}, {2, -5, 1},
            {10, -16, 1}, {-20, -40, 1}, {4, 4, 1}
    };

    static double m = 1.0; // Initial slope
    static double b = 0.0; // Initial intercept
    static double learningRate = 0.01;

    public static void main(String[] args) {
        printData();
        System.out.println(" \n Prediction and Actuals: \n");
        testPredictions();
        System.out.println(" \n Training: \n");
        singleIterationTraining();
        System.out.println(" \n Prediction and Actuals: \n");
        testPredictions();
    }

    public static void singleIterationTraining() {
        for (double[] point : points) {
            double x = point[0];
            double y = point[1];
            int actualCategory = (int) point[2];

            int predictedCategory = predict(x, y);
            int error = actualCategory - predictedCategory;

            if (error != 0) {
                System.out.println("Error: " + error);
                System.out.println("Slope: " + m);
                System.out.println("Intercept: " + b);
                // Adjust line parameters using the perceptron rule
                m += learningRate * error * x;
                b += learningRate * error;
                System.out.println("Adjusting line: New m = " + m + ", New b = " + b);
                break; // Only one adjustment in this iteration
            }
        }
    }

    public static void testPredictions() {
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
