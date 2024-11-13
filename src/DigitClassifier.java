import java.util.ArrayList;
import java.util.List;

public class DigitClassifier {

    static List<double[]> points = new ArrayList<>(); // Holds the dataset
    static double[] weights = new double[64]; // Weights for 64 features
    static double bias = 0.0; // Bias term
    static double learningRate = 0.01;
    static int maxIterations = 10000;

    public static void main(String[] args) {
        loadData(); // Load the dataset
        System.out.println("\nPrediction and Actuals before training:\n");
        testPredictions();
        System.out.println("\nTraining:\n");
        train();
        System.out.println("\nPrediction and Actuals after training:\n");
        testPredictions();
    }

    public static void train() {
        for (int i = 0; i < maxIterations; i++) {
            int errors = 0;
            for (double[] point : points) {
                double[] features = new double[64];
                System.arraycopy(point, 0, features, 0, 64);
                int t = (int) point[64];
                t = (t == 0) ? -1 : 1; // Convert labels to -1 and +1

                // Compute activation
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

    public static void loadData() {
        String[] dataLines = {
                "0,0,7,16,16,16,2,0,0,0,14,14,9,16,2,0,0,2,16,6,0,9,7,0,0,4,16,1,0,8,8,0,0,6,16,0,0,12,8,0,0,5,16,4,2,16,5,0,0,0,15,16,16,13,0,0,0,0,8,13,10,2,0,0,0",
                "0,0,7,15,13,3,0,0,0,0,16,8,9,13,0,0,0,3,13,0,1,13,3,0,0,7,14,4,0,5,8,0,0,8,16,8,0,10,8,0,0,7,16,9,0,15,3,0,0,2,16,16,11,14,1,0,0,0,5,15,15,3,0,0,0",
                "0,0,4,15,10,2,0,0,0,0,3,16,15,4,0,0,0,0,6,16,16,2,0,0,0,0,7,16,11,0,0,0,0,0,9,16,7,0,0,0,0,0,12,16,4,0,0,0,0,0,9,16,4,0,0,0,0,0,4,15,8,0,0,0,1",
                "0,0,1,12,15,2,0,0,0,0,11,13,8,10,0,0,0,4,16,13,1,10,0,0,0,8,15,3,0,6,3,0,0,8,12,0,0,8,5,0,0,2,16,8,0,8,8,0,0,0,10,11,7,15,4,0,0,0,0,13,15,6,0,0,0",
                "0,0,7,15,14,3,0,0,0,4,16,13,14,13,0,0,0,8,16,5,0,12,4,0,0,8,16,8,0,8,8,0,0,8,16,5,0,9,8,0,0,5,16,10,7,16,3,0,0,0,13,16,16,7,0,0,0,0,6,15,11,1,0,0,0",
                "0,0,0,12,13,0,0,0,0,0,4,16,16,9,0,0,0,0,2,16,6,14,0,0,0,4,3,13,7,9,5,0,0,8,12,3,16,12,8,0,0,0,14,5,1,12,8,0,0,0,10,14,13,16,2,0,0,0,0,13,16,6,0,0,0",
                "0,0,2,13,15,1,0,0,0,2,13,15,5,9,0,0,0,7,15,2,0,8,0,0,0,8,15,0,0,5,4,0,0,7,16,0,0,9,6,0,0,0,14,7,0,13,7,0,0,0,10,15,14,14,0,0,0,0,0,14,14,5,0,0,0",
                "0,0,5,15,10,2,0,0,0,0,5,16,16,11,0,0,0,0,1,16,16,16,1,0,0,0,3,14,16,11,0,0,0,0,6,16,16,10,0,0,0,0,6,16,16,2,0,0,0,0,5,16,16,9,0,0,0,0,4,16,14,10,0,0,1",
                "0,0,5,15,8,0,0,0,0,0,13,8,12,5,0,0,0,1,16,1,6,15,2,0,0,1,16,1,2,16,6,0,0,3,14,0,0,11,9,0,0,3,16,1,0,7,10,0,0,0,15,4,2,15,6,0,0,0,5,14,15,10,1,0,0",
                "0,0,12,16,14,4,0,0,0,2,16,16,16,6,0,0,0,0,12,16,16,4,0,0,0,0,15,16,16,5,0,0,0,0,16,16,16,4,0,0,0,4,16,16,15,3,0,0,0,1,14,16,16,5,0,0,0,0,10,16,16,10,0,0,1"
        };

        for (String line : dataLines) {
            String[] tokens = line.trim().split(",");
            if (tokens.length != 65) {
                System.err.println("Invalid data line (expected 65 values): " + line);
                continue;
            }
            double[] point = new double[65];
            for (int i = 0; i < 65; i++) {
                point[i] = Double.parseDouble(tokens[i]);
            }
            points.add(point);
        }
    }
}
