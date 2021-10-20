package practice;

;
import org.junit.Test;

import java.util.*;
import java.util.List;

public class OnlyWayUp {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 5, 5, 4);

        //  System.out.println(solve(2, numbers));

        System.out.println(stairs(20, 16));
    }


    public static int solve(int B, List<Integer> ar) {
        int count = 0;

        for (int i = 0; i < ar.size() - 1; i++) {
            while (ar.get(i + 1) <= ar.get(i)) {
                int newNumber = ar.get(i + 1) + B;
                ar.set((i + 1), newNumber);
                count++;
            }
        }
        System.out.println("ar = " + ar.toString());

        return count;
    }

    public static int stairs(int n, int m) {
        int minSteps = 0;

        if (n % 2 == 0) {
            minSteps = n / 2;
        } else {
            minSteps = n / 2 + 1;
        }
        while (minSteps % m != 0) {
            minSteps++;
        }
        return minSteps;
    }
}
