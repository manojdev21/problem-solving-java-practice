public class Solution {
    public static boolean checkConsecutive(int[] arr) {
        int consecutive = 0;
        for (int a : arr) {
            if (a%2 != 0) {
                consecutive++;
            } else {
                consecutive = 0;
            }
            if (consecutive == 3) return true;
        }
        return false;
    }

    public static int nthLargest(int[] arr, int n) {       // 32 29 , 29 22, 22 21, 21 12, 12 8
        int max = 0;
        int lastMax = 0;
        for (int a : arr) {
            if (a > max) {
                lastMax = max;
                max = a;
            }
        }

        while (--n > 0) {
            max = lastMax;
            lastMax = 0;
            for (int a : arr) {
                if (a < max && a > lastMax) {
                    lastMax = a;
                }
            }
        }
        // System.out.println(max + " " + lastMax);

        return max;
    }

    public static void main(String[] args) {
        int[] tc1 = {2, 6, 4, 8};
        int[] tc2 = {1, 2, 3, 4, 5, 7, 9};
        System.out.println(checkConsecutive(tc1));
        System.out.println(checkConsecutive(tc2));

        int[] arr1 = {1, 3, 8, 21, 16, 11, 2, 3, 1, 27};
        int[] arr2 = {3, 7, 8, 1, 2, 29, 12, 32, 22, 21};
        System.out.println(nthLargest(arr1, 2));
        System.out.println(nthLargest(arr2, 5));
    }
}