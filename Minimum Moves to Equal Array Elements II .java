class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); //sort the arrays
        int n = nums.length;
        int moves = 0;
        int median = nums[n/2];

        for(int num : nums){
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
