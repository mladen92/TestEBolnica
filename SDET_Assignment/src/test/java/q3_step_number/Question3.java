package q3_step_number;


public class Question3 {


    public static void main(String[] args) {
        // n is number of steps
        int n = 5;
        // array to give us combination of moves (in this case maximum will be 100 move (1 or 2 steps per move)
        int[] arr = new int[100];
        printCombinations(arr, n, 0);
    }

    // method to calculate all posible combinations
// array is number of moves, n number of total steps and i is keeping track of position in array, always has to start with 0
    static void printCombinations(int arr[], int n, int i) {
        if (n == 0) {
            for (int j = 0; j < i; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        } else if (n > 0) {
            for (int k = 1; k <= 2; k++) {
                arr[i] = k;
                printCombinations(arr, n - k, i + 1);
            }
        }
    }

}
