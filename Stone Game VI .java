import java.util.*;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        // Combine and sort stones by total value in descending order
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (i, j) -> (bobValues[j] + aliceValues[j]) - (bobValues[i] + aliceValues[i]));

        int aliceScore = 0, bobScore = 0;
        for (int turn = 0; turn < n; turn++) {
            if (turn % 2 == 0) {
                aliceScore += aliceValues[indices[turn]];
            } else {
                bobScore += bobValues[indices[turn]];
            }
        }
        return Integer.compare(aliceScore, bobScore);
    }

    public static void main(String[] args) {
        int[] aliceValues = {2, 4, 3};
        int[] bobValues = {1, 6, 7};
        Solution solution = new Solution();
        int result = solution.stoneGameVI(aliceValues, bobValues);
        System.out.println(result == 1 ? "Alice wins!" : result == -1 ? "Bob wins!" : "It's a draw!");
    }
}
