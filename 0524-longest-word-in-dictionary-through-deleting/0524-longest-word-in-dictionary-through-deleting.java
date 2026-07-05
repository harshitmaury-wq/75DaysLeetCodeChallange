class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d) ;

        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>() ;
        for(int i = 0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i))) hm.get(s.charAt(i)).add(i) ;
            else {
                ArrayList<Integer> list = new ArrayList<>() ;
                list.add(i) ;
                hm.put(s.charAt(i), list) ;
            }
        }
        int size = Integer.MIN_VALUE;
        String ans = "" ;
        for(int i = 0; i<d.size(); i++){
            String temp = d.get(i) ;
            int prev = -1;
            boolean flag = false ;
            for(int j = 0; j<temp.length(); j++){
                if(hm.containsKey(temp.charAt(j))){
                    int next = bs(prev, hm.get(temp.charAt(j))) ;
                    if(prev < next) prev = next ;
                    else{
                        flag = true;
                        break ;
                    }
                }
                else {flag = true; break ; }
            }
            if(!flag) {
                if(temp.length() > size) {size = temp.length(); ans = temp; }
            }
        }
        return ans ;
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
        if(ans == -1) return -1;
        return list.get(ans) ;
    }
}