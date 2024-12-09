public class EuclideanDistance {

    public static void main(String[] args) {
        System.out.println("Euclidean Distance");

        int[][] cities = {{1, 1}, {5, 5}, {10, 3}, {2, 7}};
        int[] sequence = new int[cities.length];


        print2DArrays(cities);

        System.out.println("Distance between city 1 and city 2: " + euclideanDistance(cities[0], cities[1]));
        System.out.println(calculatePermuations(cities, sequence, false));
    }

    public static void print2DArrays(int[][] array) {
        System.out.println("Printing 2D Array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("City " + (i + 1) + ": ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static float euclideanDistance(int[] a, int[] b) {
        // Validate input arrays
        if (a.length != 2 || b.length != 2) {
            throw new IllegalArgumentException("Both input arrays must have exactly 2 elements.");
        }

        // Compute the Euclidean distance
        return (float) Math.sqrt(Math.pow((a[0] - b[0]), 2) + Math.pow((a[1] - b[1]), 2));
    }

    public static int[] calculatePermuations(int[][] array, int[] sequence, boolean stop) {
        boolean yes = true;
        System.out.println("Calculating permuations");
        System.out.println("stop = " + stop);
        if (!stop){
            if (yes){
                stop = true;
                System.out.println("stop = true now");
            }
            calculatePermuations(array, sequence, stop);
        }
        return sequence;
    }

    public static int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
}
