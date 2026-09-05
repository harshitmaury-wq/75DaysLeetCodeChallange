class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> wv, int[][] fr, int id, int level) {
        
        int n = wv.size() ;
        int[] vis = new int[n] ;
        
        Queue<Integer> q = new LinkedList<>() ;
        vis[id] = 1;
        q.add(id) ;

        int lvl = 0 ;

        while(!q.isEmpty()) {
            int size = q.size() ;

            
            if(lvl == level) break ;
            while(size > 0) {

                int temp = q.remove() ;

                for(int i = 0; i<fr[temp].length; i++) {
                    if(vis[fr[temp][i]] == 0) {
                        vis[fr[temp][i]] =1 ;
                        q.add(fr[temp][i]) ;
                    }
                }
                size-- ;
            }
            lvl++;
        }

        HashMap<String, Integer> hm = new HashMap<>() ;

        while(!q.isEmpty()) {
            int temp = q.remove() ;

            for(int i =0 ; i<wv.get(temp).size(); i++) {
                if(hm.containsKey(wv.get(temp).get(i))) hm.put(wv.get(temp).get(i) , hm.get(wv.get(temp).get(i)) + 1) ;
                else hm.put(wv.get(temp).get(i), 1) ;
            }
        }

        List<String> list = new ArrayList<>() ;

        for(String s : hm.keySet()) {
            list.add(s) ;
        }

        Collections.sort(list, (a,b) -> {
            if(hm.get(a) < hm.get(b)) return -1 ;
            else if(hm.get(a) > hm.get(b)) return 1 ;
            else {
                if(a.compareTo(b) < 0) return -1 ;
                else if(a.compareTo(b) > 0) return 1 ;
                else return 0; 
            }
        }) ;

        return list ;
    }
}