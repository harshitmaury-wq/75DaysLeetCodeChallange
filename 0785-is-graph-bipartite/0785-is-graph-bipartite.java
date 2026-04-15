class Solution {
    class Node{
        int val;
        int col;
        Node(int val, int col){
            this.val = val;
            this.col = col;
        }
    }
    public boolean isBipartite(int[][] graph) {
        

        int m = graph.length;
        int n = graph[0].length;

        int[] color = new int[m];
        Arrays.fill(color, -1) ;

        Queue<Node> q= new LinkedList<>() ;

        for(int j=0; j<m; j++){
        if(color[j] != -1) continue;
        
        q.add(new Node(j,0));
        color[j] = 0;

        while(!q.isEmpty()){
            Node temp = q.remove() ;

            for(int i=0; i<graph[temp.val].length ; i++){
                if(color[graph[temp.val][i]] != -1){
                    if(color[graph[temp.val][i]] == color[temp.val]) return false ;

                }
                else {
                    int c;
                    if(temp.col==1) c= 0;
                    else c = 1;
                    q.add(new Node(graph[temp.val][i], c)) ;
                    color[graph[temp.val][i]] = c;
                }
            }
        }
        }
        return true;

    }
}