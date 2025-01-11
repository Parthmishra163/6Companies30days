class Solution {
    static String matrixChainOrder(int arr[]) {
        int n = arr.length;

        // dp[i][j] will hold the minimum cost of multiplying matrices from i to j
        int[][] dp = new int[n][n];

        // bracket[i][j] will store the index where the matrices are split for optimal multiplication
        int[][] bracket = new int[n][n];

        // Base case: cost of multiplying one matrix is zero
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Fill dp[][] table for chains of length 2 to n-1
        for (int len = 2; len < n; len++) { // len is the chain length
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible split point k
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        bracket[i][j] = k; // Store the split point
                    }
                }
            }
        }

        // Build and return the parenthesized result string
        return buildParenthesizedString(bracket, 1, n - 1);
    }

    // Helper function to build the parenthesized string from the bracket table
    private static String buildParenthesizedString(int[][] bracket, int i, int j) {
        if (i == j) {
            return Character.toString((char) ('A' + i - 1)); // Map matrices to letters
        }
        return "(" + buildParenthesizedString(bracket, i, bracket[i][j]) +
                buildParenthesizedString(bracket, bracket[i][j] + 1, j) + ")";
    }
}
