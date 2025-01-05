import java.util.*;

class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    s1.append(s.charAt(i));
                } else {
                    s2.append(s.charAt(i));
                }
            }

            if (s1.length() == 0 || s2.length() == 0) continue;

            int lps1 = lps(s1.toString());
            int lps2 = lps(s2.toString());

            maxProduct = Math.max(maxProduct, lps1 * lps2);
        }

        return maxProduct;
    }

    private int lps(String str) {
        int len = str.length();
        if (len == 0) return 0;

        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
