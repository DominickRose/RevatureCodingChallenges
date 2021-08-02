public class MaxMinMissing {
    public static void main(String[] args) {
        int[] arr1 = {7,5,6,4,2};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(Integer i : arr1) {
            if (i < min) min = i;
            if (i > max) max = i;
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        boolean[] present = new boolean[max - min + 1];
        for (Integer i : arr1) {
            present[i - 1 - (min - 1)] = true;
        }

        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                System.out.println("Missing: " + (i + 1 + (min - 1)));
            }
        }
    }
}
