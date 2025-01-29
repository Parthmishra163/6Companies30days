class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        long[][] dp = new long[5000][k];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return (int) (numberOfWaysHelper(startPos, endPos, 0, k, dp) % (long) (Math.pow(10, 9) + 7));
    }
    
    public long numberOfWaysHelper(int currentPos, int endPos, int stepNum, int k, long[][] dp) {
        if (stepNum == k && currentPos == endPos) {
            return 1;
        }
        if (stepNum == k && currentPos != endPos) {
            return 0;
        }
        if (dp[currentPos + 2500][stepNum] != -1) {
            return dp[currentPos + 2500][stepNum];
        }
        return dp[currentPos + 2500][stepNum] = (long) ((numberOfWaysHelper(currentPos + 1, endPos, stepNum + 1, k, dp) % (long) (Math.pow(10, 9) + 7) + numberOfWaysHelper(currentPos - 1, endPos, stepNum + 1, k, dp) % (long) (Math.pow(10, 9) + 7)));
    }
}
