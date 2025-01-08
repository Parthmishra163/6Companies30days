import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, maxSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            if (i >= k - 1) {
                if (freq.size() == k) maxSum = Math.max(maxSum, sum);
                int left = nums[i - k + 1];
                if (freq.get(left) == 1) freq.remove(left);
                else freq.put(left, freq.get(left) - 1);
                sum -= left;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        if (k > n) System.out.println("Invalid input: k > array size");
        else System.out.println("Max subarray sum: " + new Solution().maximumSubarraySum(nums, k));
    }
}
