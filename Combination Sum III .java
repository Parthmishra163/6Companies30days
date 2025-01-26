class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // create a list to store all subsets that satisfy the conditions
        List<List<Integer>> subset = new ArrayList<>();

        // create an array list to store the current subset
        ArrayList<Integer> current = new ArrayList<>();

        // generate the subsets
        generateSubset(1,9,current,subset,k,n);

        // return the list of subsets
        return subset;
    }

    // helper method to generate the subsets
    public void generateSubset(int start,int end,ArrayList<Integer> current, List<List<Integer>> subset,int k, int target){

        // if target is reached and the size of current subset is k, add current subset to the list of subsets
        if(target == 0 && current.size() == k){
            subset.add(new ArrayList(current));
        }

        // recursively generate subsets by trying all possible numbers from start to end
        for(int i = start; i <= end; i++){
            current.add(i);

            // recursively call generateSubset with updated current subset and target
            generateSubset(i+1, end, current,subset,k,target-i);

            // remove the last element from current subset before trying the next number
            current.remove(current.size() - 1);
        }
    }
}
