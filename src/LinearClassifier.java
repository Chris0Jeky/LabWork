public class LinearClassifier {

    static double[][] points = {
            {3, 3, 0}, {3, 5, 0}, {3, 18, 0}, {7, 15, 0}, {18, 18, 0}, {0, 0, 0},
            {43, 18, 0}, {-18, -1, 0}, {3, 3, 0}, {4, -1, 1}, {4, -5, 1}, {2, -5, 1},
            {10, -16, 1}, {-20, -40, 1}, {4, 4, 1}
    };

    static double[] weights = {0.0, 0.0}; // Initial weights for x and y
    static double bias = 0.0; // Initial bias
    static double learningRate = 0.01;
    static int maxIterations = 10000;

    public static void main(String[] args) {
        printData();
        System.out.println(" \n Prediction and Actuals before training: \n");
        testPredictions();
        System.out.println(" \n Training: \n");
        train();
        System.out.println(" \n Prediction and Actuals after training: \n");
        testPredictions();
    }

    public static void train() {
        for (int i = 0; i < maxIterations; i++) {
            int errors = 0;
            for (double[] point : points) {
                double x1 = point[0];
                double x2 = point[1];
                int t = (int) point[2];
                t = (t == 0) ? -1 : 1; // Adjust labels to -1 and +1

                double activation = weights[0] * x1 + weights[1] * x2 + bias;
                int y = (activation >= 0) ? 1 : -1;

                if (y != t) {
                    errors++;
                    // Update weights and bias
                    weights[0] += learningRate * t * x1;
                    weights[1] += learningRate * t * x2;
                    bias += learningRate * t;
                }
            }
            if (errors == 0) {
                System.out.println("Training completed in " + (i+1) + " iterations.");
                break;
            }
        }
        System.out.println("Final weights: w0 = " + weights[0] + ", w1 = " + weights[1] + ", bias = " + bias);
    }

    public static void testPredictions() {
        int total = 0;
        int correct = 0;

        for (double[] point : points) {
            total += 1;
            double x1 = point[0];
            double x2 = point[1];
            int actualCategory = (int) point[2];
            int predictedCategory = predict(x1, x2);
            if (predictedCategory == actualCategory) {
                correct += 1;
            }
            System.out.println("Point (" + x1 + ", " + x2 + ") - Actual: "
                    + actualCategory + ", Predicted: " + predictedCategory);

        }
        System.out.println("Correct: "  + correct + " out of " + total);
    }

    private static int predict(double x1, double x2) {
        double activation = weights[0] * x1 + weights[1] * x2 + bias;
        return (activation >= 0) ? 1 : 0;
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
