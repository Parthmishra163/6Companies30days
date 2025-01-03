class Solution {
    public int findTheWinner(int n, int k) {
        int idx = 0;
        ArrayList<Integer> arr = new ArrayList<>(n);

        for(int i=0; i<n ; i++)
        arr.add(i);

        while(arr.size()>1)
        {
            idx=idx+(k-1);
            idx=idx % arr.size();
            arr.remove(idx);
        }
        return arr.get(0)+1;
    }
}
