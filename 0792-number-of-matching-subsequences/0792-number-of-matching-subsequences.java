class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, ArrayList<Integer>> hm= new HashMap<>() ;
        for(int i = 0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i))) hm.get(s.charAt(i)).add(i) ;
            else {
                ArrayList<Integer> list = new ArrayList<>() ;
                list.add(i) ;
                hm.put(s.charAt(i), list) ;
            }
        }
        int prev = -1 ;
        int c = 0;
        boolean flag = false ;
        for(int i = 0; i<words.length; i++){
            String temp = words[i] ;
            flag = false ;
            prev = -1 ;
            for(int j = 0; j<temp.length(); j++){
                
            if(hm.containsKey(temp.charAt(j)) ) {
                int next = bs(prev, hm.get(temp.charAt(j)) ) ;
                if(next > prev ) prev = next ;
                else {flag = true; break ;}
            }
            else {flag = true; break ; }
            }
            if(!flag) c++;
        }
        return  c;
    }

    int bs (int prev, ArrayList<Integer> list){
        if(prev == -1) return list.get(0) ;
        int s = 0; 
        int e = list.size()-1 ;
        int ans = -1;
        while(s<=e){
            int mid = s + (e - s) / 2 ;

            if(list.get(mid) > prev) {ans = mid; e = mid - 1 ;} 
            else s = mid + 1 ;
        }
        if(ans == -1) return -1 ;
        return list.get(ans);
        
    }
}