public class LinearClassifier {
    
    static double[][] points = {
            {3, 3, 0}, {3, 5, 0}, {3, 18, 0}, {7, 15, 0}, {18, 18, 0}, {0, 0, 0},
            {43, 18, 0}, {-18, -1, 0}, {3, 3, 0}, {4, -1, 1}, {4, -5, 1}, {2, -5, 1},
            {10, -16, 1}, {-20, -40, 1}, {4, 4, 1},
            {1, 1, 0}, {1, 2, 0}, {3, 3, 0}, {4, 1, 1}, {5, 2, 1}, {4, 1, 1}, {6, 6, 1}
    };

    public static void main(String[] args) {
        printData();
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
