class Solution {
    int[] ans ;
    int x = 0;

    public int[] restoreArray(int[][] ap) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>() ;
        this.ans = new int[ap.length + 1] ;
        
        for(int i = 0; i<ap.length; i++) {

            int x = ap[i][0] ;
            int y = ap[i][1] ;

            if(graph.containsKey(x)) graph.get(x).add(y) ;
            else {
                List<Integer> list = new ArrayList<>() ;
                list.add(y) ;
                graph.put(x, list) ;
            }
            if(graph.containsKey(y)) graph.get(y).add(x) ;
            else {
                List<Integer> list = new ArrayList<>() ;
                list.add(x) ;
                graph.put(y, list) ;
            }
        }
        HashSet<Integer> vis = new HashSet<>() ;

            for(Integer i : graph.keySet()){
                if(graph.get(i).size() == 1) {
                    fun(graph, i, vis) ;
                    break ;
                }
            }
        return ans ;
    }
    

    void fun(HashMap<Integer, List<Integer>> graph,int s, HashSet<Integer> vis){
        if(vis.contains(s) || x == ans.length) return ;

        vis.add(s) ;
        ans[x++] = s ;

        for(int i = 0; i<graph.get(s).size(); i++) {
            fun(graph, graph.get(s).get(i), vis) ;
        }


    }
}