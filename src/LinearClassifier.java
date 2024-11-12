public class LinearClassifier {

    static double m = 1.0; // Initial slope
    static double b = 0.0; // Initial intercept
    static double learningRate = 0.01;
    static int maxIterations = 1000;

//    double[][] points = {
//            {2.0, 3.0, 0},
//            {1.0, 1.5, 0},
//            {4.0, 5.0, 1},
//            {6.0, 7.5, 1}
//    };

    static double[][] points = {
            {3, 3, 0}, {3, 5, 0}, {3, 18, 0}, {7, 15, 0}, {18, 18, 0}, {0, 0, 0},
            {43, 18, 0}, {-18, -1, 0}, {3, 3, 0}, {4, -1, 1}, {4, -5, 1}, {2, -5, 1},
            {10, -16, 1}, {-20, -40, 1}, {4, 4, 1},
            {1, 1, 0}, {1, 2, 0}, {3, 3, 0}, {4, 1, 1}, {5, 2, 1}, {4, 1, 1}, {6, 6, 1}
    };

    public static void main(String[] args) {
        System.out.println("Hello world!");
        train();
        test();


    }

    public static void train() {
        for (int i = 0; i < maxIterations; i++) {
            int errors = 0;
            for (double[] point : points) {
                double x = point[0];
                double y = point[1];
                int category = (int) point[2];

                int predictedCategory = predict(x, y);
                int error = category - predictedCategory;

                if (error != 0) {
                    errors++;
                    // Adjust line parameters using the perceptron learning rule
                    m += learningRate * error * x;
                    b += learningRate * error;
                }
            }
            if (errors == 0) break; // Stop if no errors
        }
        System.out.println("Training completed: y = " + m + "x + " + b);
    }

    public static int predict(double x, double y) {
        double lineY = m * x + b;
        return (y > lineY) ? 1 : 0;
    }

    public static void test() {
        for (double[] point : points) {
            double x = point[0];
            double y = point[1];
            int actualCategory = (int) point[2];
            int predictedCategory = predict(x, y);
            System.out.println("Point (" + x + ", " + y + ") - Actual: "
                    + actualCategory + ", Predicted: " + predictedCategory);
        }
    }
}