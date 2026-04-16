class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int[] vis = new int[graph.length] ;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>() ;

        fun(list, temp, graph, 0, vis) ;
        return list;
    }
    static void fun (List<List<Integer>> list, List<Integer>temp, int[][]g, int s, int[] vis){

    
        if( s== g.length - 1) {
            temp.add(s) ;
            list.add(new ArrayList<>(temp));
             temp.remove(temp.size()-1) ;
            return;
        }
        vis[s] = 1;
        temp.add(s) ;
        for(int i=0; i<g[s].length; i++){
            if(vis[g[s][i]]==0)  {
                fun(list, temp, g, g[s][i], vis) ;
            }
        }
        temp.remove(temp.size()-1) ;
        vis[s] = 0;
    }
}