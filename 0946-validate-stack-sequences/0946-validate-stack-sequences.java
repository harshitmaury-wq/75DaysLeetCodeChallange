class Solution {
    public boolean validateStackSequences(int[] push, int[] pop) {
        Stack<Integer> st = new Stack<>() ;

        int i = 0; 
        int j = 0; 

        while(i < push.length && j < pop.length) {
           
            if(push[i] == pop[j]) {
                i++;
                j++ ;
            }
            else if (!st.isEmpty() && pop[j] == st.peek()) {
                j++;
                st.pop() ;
            }
            else if(push[i] != pop[j]) {
               st.push(push[i]) ;
               i++ ;
            }
        }

        while(j<pop.length && !st.isEmpty() ){
            if(pop[j] == st.peek()) {
            st.pop() ;
            j++ ;
            }

            else return false ;
        }

        if(st.isEmpty() ) return true ;
        return false ;
    }
}