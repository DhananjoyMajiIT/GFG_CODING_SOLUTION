class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         int[]dist=new int [n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<=k;i++){
            int []temp=Arrays.copyOf(dist,dist.length);
            for(int []f:flights){
                int fr=f[0];
                int dis=f[1];
                int pri=f[2];
                if(dist[fr]!=Integer.MAX_VALUE){
                    temp[dis]=Math.min(temp[dis],dist[fr]+pri);
                }
            }
            dist=temp;
        }
        return dist[dst]==Integer.MAX_VALUE ? -1:dist[dst];
    }
}