import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }

        Arrays.sort(nums);
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // Populate the dp array with the length of the longest subset ending at each index
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        // Backtrack to find the elements of the largest divisible subset
        int prev = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (dp[i] == max && (prev % nums[i] == 0 || prev == -1)) {
                ans.add(nums[i]);
                max--;
                prev = nums[i];
            }
        }

        return ans;
    }
}
