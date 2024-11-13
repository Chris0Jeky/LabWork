public class LinearClassifier64D {

    static double[][] points; // To be initialized with 64-dimensional data
    static double[] weights = new double[64]; // Initial weights for 64 features
    static double bias = 0.0; // Initial bias
    static double learningRate = 0.01;
    static int maxIterations = 3;

    public static void main(String[] args) {
        generateData(); // Generate the dataset
        printData();
        System.out.println(" \nPrediction and Actuals before training:\n");
        testPredictions();
        System.out.println(" \nTraining:\n");
        train();
        System.out.println(" \nPrediction and Actuals after training:\n");
        testPredictions();
    }

    public static void train() {
        for (int i = 0; i < maxIterations; i++) {
            int errors = 0;
            for (double[] point : points) {
                double[] features = new double[64];
                System.arraycopy(point, 0, features, 0, 64);
                int t = (int) point[64];
                t = (t == 0) ? -1 : 1; // Adjust labels to -1 and +1

                double activation = 0.0;
                for (int j = 0; j < 64; j++) {
                    activation += weights[j] * features[j];
                }
                activation += bias;

                int y = (activation >= 0) ? 1 : -1;

                if (y != t) {
                    errors++;
                    // Update weights and bias
                    for (int j = 0; j < 64; j++) {
                        weights[j] += learningRate * t * features[j];
                    }
                    bias += learningRate * t;
                }
            }
            if (errors == 0) {
                System.out.println("Training completed in " + (i + 1) + " iterations.");
                break;
            }
        }
        System.out.println("Final weights and bias obtained after training.");
    }

    public static void testPredictions() {
        int total = 0;
        int correct = 0;

        for (double[] point : points) {
            total += 1;
            double[] features = new double[64];
            System.arraycopy(point, 0, features, 0, 64);
            int actualCategory = (int) point[64];
            int predictedCategory = predict(features);
            if (predictedCategory == actualCategory) {
                correct += 1;
            }
            System.out.println("Point " + total + " - Actual: "
                    + actualCategory + ", Predicted: " + predictedCategory);
        }
        System.out.println("Correct: " + correct + " out of " + total);
    }

    private static int predict(double[] features) {
        double activation = 0.0;
        for (int j = 0; j < 64; j++) {
            activation += weights[j] * features[j];
        }
        activation += bias;
        return (activation >= 0) ? 1 : 0;
    }

    public static void printData() {
        int count = 1;
        for (double[] point : points) {
            System.out.print("Point " + count + " - Features: [");
            for (int i = 0; i < 64; i++) {
                System.out.print(point[i]);
                if (i < 63) System.out.print(", ");
            }
            System.out.println("] - Category: " + (int) point[64]);
            count++;
        }
    }

    public static void generateData() {
        int numPoints = 100; // Number of data points
        points = new double[numPoints][65]; // 64 features + 1 label

        java.util.Random rand = new java.util.Random();

        // Generate data for category 0
        for (int i = 0; i < numPoints / 2; i++) {
            for (int j = 0; j < 64; j++) {
                points[i][j] = rand.nextDouble() * 0.5; // Features between 0.0 and 0.5
            }
            points[i][64] = 0; // Label
        }

        // Generate data for category 1
        for (int i = numPoints / 2; i < numPoints; i++) {
            for (int j = 0; j < 64; j++) {
                points[i][j] = rand.nextDouble() * 0.5 + 0.5; // Features between 0.5 and 1.0
            }
            points[i][64] = 1; // Label
        }
    }
}
