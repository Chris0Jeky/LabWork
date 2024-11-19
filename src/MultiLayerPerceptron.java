public class MultiLayerPerceptron {

    // First perceptron
    double w1_p1 = 0.5;
    double w2_p1 = 0.5;
    double bias_p1 = -0.5;

    // Second perceptron
    double w1_p2 = 1.0;
    double w2_p2 = -1.0;
    double bias_p2 = 0.5;

    // Third perceptron
    double w1_p3 = -1.0;
    double w2_p3 = 1.0;
    double bias_p3 = 0.5;

    public int perceptron1(double input1, double input2) {
        double sum = (input1 * w1_p1) + (input2 * w2_p1) + bias_p1;
        return stepFunction(sum);
    }

    public int perceptron2(double input1, double input2) {
        double sum = (input1 * w1_p2) + (input2 * w2_p2) + bias_p2;
        return stepFunction(sum);
    }

    public int perceptron3(double input1, double input2) {
        double sum = (input1 * w1_p3) + (input2 * w2_p3) + bias_p3;
        return stepFunction(sum);
    }

    public int stepFunction(double sum) {
        return (sum >= 0) ? 1 : 0;
    }

    public static void main(String[] args) {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron();
        double input1 = 1.0;
        double input2 = 2.0;

        int output1 = mlp.perceptron1(input1, input2);
        int output2 = mlp.perceptron2(input1, input2);
        int output3 = mlp.perceptron3(input1, input2);

        System.out.println("Output of Perceptron 1: " + output1);
        System.out.println("Output of Perceptron 2: " + output2);
        System.out.println("Output of Perceptron 3: " + output3);
    }
}
