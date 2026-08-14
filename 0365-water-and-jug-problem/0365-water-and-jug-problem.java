class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        int[][] vis = new int[x+1][y+1] ;
        return fun(x,y,target, 0, 0, vis) ;
    }
    boolean fun(int x, int y, int t, int a, int b, int[][] vis){
        if(a > x || b > y || a<0 || b<0 || vis[a][b] == 1) return false ;
        if(a + b == t) return true ;

        vis[a][b] = 1 ;
        boolean one = fun(x, y, t, a, y, vis) ;
        boolean two = fun(x, y, t, x, b, vis) ;
        boolean three = fun(x, y, t, a, 0, vis) ;
        boolean four = fun(x, y, t, 0, b, vis) ;
        boolean five = fun(x, y, t, a+b > x ? x: a+b, a+b<x?0:b-(x-a), vis) ;
        boolean six = fun(x, y, t, a+b<y?0:a-(y-b), a+b > y ? y : a+b, vis) ;

        return one||two||three||four||five||six ;
    }
}