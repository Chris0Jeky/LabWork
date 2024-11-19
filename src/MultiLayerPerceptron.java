public class MultiLayerPerceptron {

    double weight1 = 0.5;
    double weight2 = 0.5;
    double bias = 0.5;

    public int stepFunction(double sum) {
        return (sum >= 0) ? 1 : 0;
    }

    // Perceptron with two inputs
    public double perceptron(double input1, double input2) {
        // Linear transfer function: output = input
        double sum = (input1 * weight1) + (input2 * weight2) + bias;
        return stepFunction(sum); // Pass-through function
    }

    public static void main(String[] args) {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron();
        double output = mlp.perceptron(1.0, 2.0);
        System.out.println("Output: " + output);
    }
}
