class DataStream {
    int ct = 0;
    int val = 0;
    int K = 0;
    public DataStream(int value, int k) {
        ct = 0;
        val = value;
        K = k;
    }
    
    public boolean consec(int num) {
        if(num==val){
            ct++;
            if(ct<K){
                return false;
            }
            return true;
        }else{
            ct = 0;
            return false;
        }
    }
}
