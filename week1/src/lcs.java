import java.util.ArrayList;
import java.util.Collections;

public class lcs {
    public static void main(String[] args) {
        String a = "Minneapolis";
        String b = "Minnesota";

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            ArrayList<Integer> internal = new ArrayList<>();
            for (int j = 0; j < b.length(); j++) {
                if ((i == 0 || j == 0) && a.charAt(i) == b.charAt(j))
                    internal.add(1);
                else
                    internal.add(0);
            }
            dp.add(internal);
        }

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    int previous = dp.get(i - 1).get(j - 1);
                    dp.get(i).set(j, previous + 1);
                }
                else {
                    dp.get(i).set(j, 0);
                }
            }
        }

        int overallMax = Integer.MIN_VALUE;
        for (ArrayList<Integer> row : dp) {
            int subMax = Collections.max(row);
            if (subMax > overallMax)
                overallMax = subMax;
        }
        System.out.println("Length of LCS is: " + overallMax);
    }
}
