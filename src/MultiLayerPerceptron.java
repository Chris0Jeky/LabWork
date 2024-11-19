public class MultiLayerPerceptron {

    double weight1 = 0.5;
    double weight2 = 0.5;

    // Perceptron with two inputs
    public double perceptron(double input1, double input2) {
        // Linear transfer function: output = input
        double sum = (input1 * weight1) + (input2 * weight2);
        return sum; // Pass-through function
    }

    public static void main(String[] args) {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron();
        double output = mlp.perceptron(1.0, 2.0);
        System.out.println("Output: " + output);
    }
}
