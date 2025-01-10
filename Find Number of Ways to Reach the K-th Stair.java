import java.util.HashMap;

class Solution {
    private HashMap<String, Integer> mp;
    private long[] power;
    private int K;

    private int solve(int i, int jump, int canGoBack) {
        if (i > K + 1)
            return 0;

        String key = i + "_" + jump + "_" + canGoBack;

        if (mp.containsKey(key))
            return mp.get(key);

        int count = 0;

        if (i == K) {
            count++;
        }

        if (canGoBack == 1) {
            count += solve(i - 1, jump, 0);
        }

        count += solve(i + (int) power[jump], jump + 1, 1);

        mp.put(key, count);
        return count;
    }

    public int waysToReachStair(int k) {
        mp = new HashMap<>();
        power = new long[33];
        K = k;

        for (int i = 0; i < 33; ++i) {
            power[i] = (long) Math.pow(2, i);
        }

        return solve(1, 0, 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 10; // Example input
        System.out.println("Ways to reach stair " + k + ": " + solution.waysToReachStair(k));
    }
}
