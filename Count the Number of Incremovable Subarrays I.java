class Solution {
    public int incremovableSubarrayCount(int[] nums) {
int count = 0;
    int countm = 0;
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0 ; i <= nums.length - 1 ; i++){
        for(int j = i; j <= nums.length - 1 ; j++){
            for( int k = 0 ; k <= nums.length-1 ; k++){
                if(k<i || k>j){
                    list.add(nums[k]);
                }
            }
            for(int l = 0; l<=list.size()-1 ; l++){
                if(l == list.size()-1){
                    break;
                }
                else{
                    if(list.get(l)<list.get(l+1)){
                        count++;
                    }
                    else{

                    }
                }
            }
            if(count==list.size()-1)
            {
                countm++;
            }
            count=0;
            list.clear();
        }
    }
       return countm+1;
    }
}
