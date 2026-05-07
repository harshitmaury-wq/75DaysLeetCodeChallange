class Solution {
    public List<Integer> eventualSafeNodes(int[][] edges) {
        int[] indeg = new int[edges.length] ;
        ArrayList<ArrayList<Integer>> revlist = new ArrayList<>() ;
        ArrayList<Integer> ans = new ArrayList<>() ;
        for(int i=0; i<edges.length; i++){
            revlist.add(new ArrayList<>()) ;
        }

        Queue<Integer> q = new LinkedList<>() ;

        for(int i=0; i<edges.length; i++){
            for(int j=0; j<edges[i].length; j++){
                revlist.get(edges[i][j]).add(i) ;
                indeg[i]++;
            }
        }

        for(int i = 0; i<indeg.length; i++){
            if(indeg[i]==0) q.add(i) ;
        }

        while(!q.isEmpty()){
            int temp = q.remove() ;
            ans.add(temp) ;

            for(int i=0; i<revlist.get(temp).size(); i++){
                indeg[revlist.get(temp).get(i)]--;
                if( indeg[revlist.get(temp).get(i)]==0) q.add(revlist.get(temp).get(i)) ;
            }

        }
        Collections.sort(ans) ;

        return ans;

    }
}