public class MultiLayerPerceptron {

    // Perceptron with two inputs
    public double perceptron(double input1, double input2) {
        // Linear transfer function: output = input
        double sum = input1 + input2;
        return sum; // Pass-through function
    }

    public static void main(String[] args) {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron();
        double output = mlp.perceptron(1.0, 2.0);
        System.out.println("Output: " + output);
    }
}
