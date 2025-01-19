
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
if (n == 0)
return 0;

    Arrays.sort(envelopes, (a, b) -> {
        if (a[0] == b[0]) 
            return b[1] - a[1]; 
        return a[0] - b[0];
    });

    int[] dp = new int[n];
    int length = 0;

    for (int[] envelope : envelopes) {
        int height = envelope[1];
        int index = Arrays.binarySearch(dp, 0, length, height);
        if (index < 0) index = -(index + 1);
        dp[index] = height;
        if (index == length) length++;
    }

    return length;
}
}
