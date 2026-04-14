class Solution {
    class Node{
        int r;
        int c;
        int distance;
        Node(int r, int c, int distance){
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] visi = new int[m][n];
        int[][] dis = new int[m][n] ;

        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0) {
                q.add(new Node(i, j, 0));
                visi[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()){
            Node temp = q.remove() ;
            dis[temp.r][temp.c] = temp.distance;

            if(temp.r+1 <m && visi[temp.r+1][temp.c]==0){
                q.add(new Node(temp.r+1, temp.c, temp.distance+1));
                visi[temp.r+1][temp.c] = 1;
            }
            
            if(temp.r-1 >=0 && visi[temp.r-1][temp.c]==0){
                q.add(new Node(temp.r-1, temp.c, temp.distance+1));
                visi[temp.r-1][temp.c] = 1;
            }
            
            if(temp.c+1 <n && visi[temp.r][temp.c+1]==0){
                q.add(new Node(temp.r, temp.c+1, temp.distance+1));
                visi[temp.r][temp.c+1] = 1;
            }
            
            if(temp.c-1 >=0 && visi[temp.r][temp.c-1]==0){
                q.add(new Node(temp.r, temp.c-1, temp.distance+1));
                visi[temp.r][temp.c-1] = 1;
            }

        }
        return dis;
    }
}