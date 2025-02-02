class Solution {
   public int maxSubarrayLength(int[] nums, int k) {
        int start = 0, end = 0, result = 1;
        Map<Integer, Integer> freq = new HashMap<>();

        while(end < nums.length) {
            int currentFreq = freq.getOrDefault(nums[end], 0);

            if(currentFreq < k) {
                freq.put(nums[end], currentFreq+1);
            }
            else {
                while(nums[start] != nums[end]) {
                    freq.put(nums[start], freq.get(nums[start])-1);
                    start++;
                }
                start++;
            }

            int newWindowLength = end-start+1;
            result = Math.max(result, newWindowLength);

            end++;

        }

        return result;
    }
}
