class Solution {
    public int numFriendRequests(int[] ages) {
        
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        int count = 0;

        for(int i : ages){
            mapA.put(i, mapA.getOrDefault(i, 0) + 1);
        }

        for(int i : ages ){
            mapB.put(i, mapB.getOrDefault(i,0) + 1);
        }

       for(int ageA : mapA.keySet()){
        for(int ageB : mapB.keySet()){
           
           if(ageB > 100 && ageA < 100) continue;
           if(ageB > ageA) continue;
           if(ageB <= 0.5 * ageA + 7) continue;

           count += mapA.get(ageA) * mapB.get(ageB);

           if(ageA == ageB){
            count -= mapA.get(ageA);
           }
        }
       }
       return count;
    }
}
