package michael.exam.apcsa15;

public class DiverseArray {
    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    public static int[] rowSums(int[][] arr2D) {
        int[] sums = new int[arr2D.length];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = arraySum(arr2D[i]);
        }
        return sums;
    }
    
    public static boolean isDiverse(int[][] arr2D) {
        int[] sums = rowSums(arr2D);
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                if (sums[i] == sums[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
