import java.util.Arrays;

public class EuclideanDistance {

    public static void main(String[] args) {
        System.out.println("Euclidean Distance");

        int[][] cities = {{1, 1}, {5, 5}, {10, 3}, {2, 7}};
        int[] initialSequence = new int[cities.length];
        for (int i = 0; i < cities.length; i++) {
            initialSequence[i] = i;
        }
        permute(cities, initialSequence, 0);


        print2DArrays(cities);

        System.out.println("Distance between city 1 and city 2: " + euclideanDistance(cities[0], cities[1]));


    }

    static float bestDistance = Float.MAX_VALUE;
    static int[] bestSequence;

    private static void permute(int[][] cities, int[] sequence, int start) {
        if (start == sequence.length - 1) {
            float dist = totalDistance(cities, sequence);
            System.out.println("Permutation: " + Arrays.toString(sequence) + " Distance: " + dist);
            if (dist < bestDistance) {
                bestSequence = sequence.clone();
                bestDistance = dist;
            }
            return;
        }

        for (int i = start; i < sequence.length; i++){
            swap(sequence, start, i);
            permute(cities, sequence, start + 1);
            swap(sequence, start, i);
        }
    }

    private static float totalDistance(int[][] cities, int[] sequence) {
        float dist = 0f;
        for (int i = 0; i < sequence.length - 1; i++) {
            dist += euclideanDistance(cities[sequence[i]], cities[sequence[i + 1]]);
        }
        return dist;
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



    public static int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
}
