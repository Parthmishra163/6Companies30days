class Solution {
    public int longestMountain(int[] A) {
        int res = 0;
        int n=A.length;

        for(int i=1;i<n;i++){
            int count=1;
            boolean flag=false;

            int j=i;

            while(j<n && A[j]>A[j-1]){
                j++;
                count++;
            }
            while(i!=j && j<n && A[j]<A[j-1]){
                j++;
                count++;
                flag=true;
            }
            if(i!=j && flag && count>2){
                res=Math.max(res,count);
                j--;
            }
            i = j;
        }
        return res;
    }
}
