class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
         ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;

        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>()) ;
        }
        int[] indeg = new int[numCourses] ;

        for(int i = 0; i<pre.length; i++){
            list.get(pre[i][1]).add(pre[i][0]);
            indeg[pre[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>() ;
        for(int i=0; i<indeg.length; i++){
            if(indeg[i]==0) q.add(i) ;
        }

        ArrayList<Integer> t = new ArrayList<>() ;
        while(!q.isEmpty()) {
            int temp = q.remove() ;
            t.add(temp) ;

            for(int i=0; i<list.get(temp).size(); i++){
                indeg[list.get(temp).get(i)]--;
                if(indeg[list.get(temp).get(i)] ==0) q.add(list.get(temp).get(i)) ;
            }

        }
        if(t.size() != numCourses) return new int[]{} ;
        int[] ans = new int[t.size()] ;
        for(int i = 0; i<t.size(); i++) ans[i] = t.get(i) ;
        return ans ;
    }
}