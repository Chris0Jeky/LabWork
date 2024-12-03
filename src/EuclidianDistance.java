public class EuclidianDistance {

    public static void main(String[] args) {
        System.out.println("Euclidian Distance");

        int[][] cities = {{1, 1}, {5, 5}, {10,3}, {2,7}};

        print2DArrays(cities);


    }

    public static void print2DArrays(int[][] array){
        System.out.println("Printing 2D Array \n");
        for (int i = 0; i < array.length; i++) {
            System.out.println("outer array " + i);
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static float euclidianDistance(int[] a, int[] b){
        float result = 0.0F;
        double aD = a;
//        result = Math.sqrt(Math.pow(

        return result;
    }
}
