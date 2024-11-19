import java.util.Arrays;

public class MultiLayerPerceptron {

    // Weights for input to hidden layer
    double[][] weights_input_hidden = {
            {0.5, 0.5},   // Weights for first hidden neuron
            {0.5, -0.5}   // Weights for second hidden neuron
    };
    double[] bias_hidden = {-0.5, 0.5}; // Biases for hidden neurons

    // Weights for hidden to output layer
    double[] weights_hidden_output = {1.0, 1.0}; // Weights for output neuron
    double bias_output = -1.0; // Bias for output neuron

    public int multiLayerPerceptron(double input1, double input2) {
        // Hidden layer computations
        System.out.println("weights of neuron 1" + Arrays.toString(weights_input_hidden[0]));
        System.out.println("weights of neuron 2" + Arrays.toString(weights_input_hidden[1]));
        double[] hidden_outputs = new double[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("input1 " + input1 + " input2 " + input2);
            System.out.println("hidden output [i] " + hidden_outputs[i]);
            double sum = (input1 * weights_input_hidden[i][0]) + (input2 * weights_input_hidden[i][1]) + bias_hidden[i];
            hidden_outputs[i] = stepFunction(sum);
            System.out.println("Step function of sum hidden " + hidden_outputs[i]);
        }

        // Output layer computation
        double sum_output = (hidden_outputs[0] * weights_hidden_output[0]) +
                (hidden_outputs[1] * weights_hidden_output[1]) +
                bias_output;
        System.out.println("sum output " + sum_output);
        int output = stepFunction(sum_output);
        System.out.println("step function of sum output " + output);

        return output;
    }

    public int stepFunction(double sum) {
        return (sum >= 0) ? 1 : 0;
    }

    public static void main(String[] args) {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron();
        double input1 = 0.0;
        double input2 = 1.0;

        int output = mlp.multiLayerPerceptron(input1, input2);
        System.out.println("Output: " + output);
    }
}
