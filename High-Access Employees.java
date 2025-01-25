class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, PriorityQueue<String>> map = new HashMap();
        for(List<String> a : access_times) {
            String name = a.get(0), time = a.get(1);
            map.computeIfAbsent(name, k -> new PriorityQueue()).offer(time);
        }
        //System.out.println(map);
        List<String> res = new ArrayList();
        for(String n : map.keySet()) {
            PriorityQueue<String> pq = map.get(n);
            if(pq.size() < 3) continue;
            int prev2 = Integer.valueOf(pq.poll());
            int prev1 = Integer.valueOf(pq.poll());
            
            while(!pq.isEmpty()) {
                int curr = Integer.valueOf(pq.poll());
                if(curr - prev2 < 100) { res.add(n); break; }
                prev2 = prev1; prev1 = curr;
            }
        }
        return res;
    }
}
