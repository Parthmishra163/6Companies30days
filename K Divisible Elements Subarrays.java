class Solution {

    class Node{

        boolean found;
        Node[] ch;
        public Node(){
            this.found = false;
            this.ch = new Node[201];
        }
    }

    Node curr = new Node();
    int res=0;

    void build(int[] nums, int a, int b){

        //Building the Trie and increasing the count (res) if
        //the node is visited for the first time 
        Node root = curr;
        for(int i=b;i>=a;i--){

            if(root.ch[nums[i]]==null){
                root.ch[nums[i]] = new Node();
                res++;
            }
            root = root.ch[nums[i]];
        }
        
    }
    
    public int countDistinct(int[] nums, int k, int p) {
        
        //Queue<Integer> que = new LinkedList<>();
        int n = nums.length;
        int start =0;
        int count=0;
        
        for(int i=0;i<n;i++){

            if(nums[i]%p==0)count++;

            while(count>k){
                if(nums[start++]%p==0)count--;
            }
            // Can also use a queue to find the index
            // of last occurence of an element divisible by p
            //if(que.size()>k)start = que.poll()+1;
            build(nums, start, i); 
        }
        return res;

    }
}
