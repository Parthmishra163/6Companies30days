class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] i: dist){
            Arrays.fill(i, 100000);
        } 
        for(int i=0 ; i<n; i++){
            dist[i][i] = 0;
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        for(int node=0 ; node<n ; node++){
            for(int u=0 ; u<n ; u++){
                for(int v=0 ; v<n ; v++){
                    if(dist[u][v]>dist[u][node]+dist[node][v]){
                        dist[u][v] = dist[u][node]+ dist[node][v];
                    }
                }
            }
        }
        int min = 100000;
        int ans = -1;
        for(int i=0; i<n;i++){
            int count = 0;
            for(int j=0 ; j<n ; j++){
                if(j!=i && dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                ans = i;
                min = count;
            }
        }
        return ans;
    }
}
