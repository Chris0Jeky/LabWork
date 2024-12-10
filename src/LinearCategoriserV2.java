import java.util.Arrays;

public class LinearCategoriserV2 {


    static int slope = 2;
    static int offset = 1;

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(Arrays.toString(returnLine(3, slope, offset)));
    }


    static double[][] points = {
            {3, 3, 0}, {3, 5, 0}, {3, 18, 0}, {7, 15, 0}, {18, 18, 0}, {0, 0, 0},
            {43, 18, 0}, {-18, -1, 0}, {3, 3, 0}, {4, -1, 1}, {4, -5, 1}, {2, -5, 1},
            {10, -16, 1}, {-20, -40, 1}, {4, 4, 1}
    };

    public static int[] returnLine(int y, int m, int b) {
        int[] line = new int[2];
        int x = m * y + b;
        //x=my+b
        line[0] = x;
        line[1] = y;
        return line;
    }

/*
3.	Put in an array of 2D points in two categories; the category can be represented by a third integer point.
4.	Make a line that separates them. Remember, a line can be represented many ways including by two points,
 and by the equation x=my+b (where m is the slope constant and b is the offset from the origin).
5.	In response to data, move the line. You can try the perceptron learning rule, or just move it gradually.
*/
}
