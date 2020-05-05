package a1_2_dispatcher;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = execute(new Quadratic(), 5);
        int[] arr2 = execute(new Quadratic(), 2);
        int[] arr3 = execute(new Quadratic(), 7);
        int[] arr4 = execute(new Quadratic(), 4);
        
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
    }

    public static int[] execute(F f, int n) {
        Result result = new Result(n);

        for (int i = 0; i < n; i++){
            FThread t = new FThread(f, i, result);
            t.start();
        }

        return result.getResults();
    }
}