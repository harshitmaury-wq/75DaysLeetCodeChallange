class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        Stack<Integer> st = new Stack<>() ;


        List<Integer> list = new ArrayList<>() ;
        for(int i = 0 ;i<position.length; i++) {
            if(st.isEmpty()) st.push(speed[i]) ;

            else {
                if(Math.abs(position[i] - position[i-1]) <= distance) {
                    st.pop() ;
                    st.push(speed[i]) ;
                } 
                else {
                    st.push(speed[i]) ;
                }
            }
        }

        while(!st.isEmpty()) list.add(st.pop()) ;

        Collections.reverse(list) ;
        for(int i = 0; i<list.size(); i++) {
            if(st.isEmpty()) st.push(list.get(i)) ;

            else {
                while(!st.isEmpty() && list.get(i) < st.peek()) {
                    st.pop() ;
                    
                }
                st.push(list.get(i)) ;
            }
        }
        return st.size();
    }
}