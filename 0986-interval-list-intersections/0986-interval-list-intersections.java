class Solution {
    public int[][] intervalIntersection(int[][] f, int[][] s) {
        ArrayList<int[]> list = new ArrayList<>() ;
        for(int i = 0; i<s.length; i++){
            list.add(new int[]{s[i][0] , 1}) ;
            list.add(new int[]{s[i][1] , -1}) ;

        }
        for(int i = 0; i<f.length; i++){
            list.add(new int[]{f[i][0] , 1}) ;
            list.add(new int[]{f[i][1] , -1}) ;

        }
        Collections.sort(list, (a,b) -> {
            if(a[0] < b[0]) return -1;
            else if(a[0] > b[0]) return 1;
            else {
                if(a[1] < b[1]) return 1;
                else if(a[1] > b[1]) return -1;
                return 0;
            }
        }) ;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
        ArrayList<Integer> temp = new ArrayList<>() ;
        int c = 0;
        for(int i = 0; i<list.size(); i++) {
            int pc= c ;
            c+=list.get(i)[1] ;
            if(c == 2 && pc == 1) {
                temp.add(list.get(i)[0]) ;
            }
            else if(c == 1 && pc == 2) {
                temp.add(list.get(i)[0]) ;
                ans.add(new ArrayList<>(temp)) ;
                temp.clear() ;
            }

        }
        int[][] arr = new int[ans.size()][2] ;
        for(int i = 0; i<arr.length; i++) {
            arr[i][0] = ans.get(i).get(0) ;
            arr[i][1] = ans.get(i).get(1) ;
        }
        return arr ;
    }
}