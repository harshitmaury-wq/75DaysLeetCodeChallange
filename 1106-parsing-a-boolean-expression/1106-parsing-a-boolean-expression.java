class Solution {
    public boolean parseBoolExpr(String e) {
        Stack<Character> st = new Stack<>() ;

        for(int i = 0; i<e.length(); i++){
           if(e.charAt(i)==',' ) continue;
           else if(e.charAt(i)==')'){
            ArrayList<Boolean> list = new ArrayList<>();
            while(st.peek()=='f' || st.peek()=='t'){
                if(st.pop()=='f') list.add(false );
                else list.add(true) ;
            }
            st.pop();
            if(fun(list, st.pop())) st.push('t');
            else st.push('f') ;
           }
           else st.push(e.charAt(i)) ;
        }
        return st.pop()=='t' ? true : false ; 
    }
    boolean fun (ArrayList<Boolean> list, char c){
        if(c=='!') return !list.get(0) ;
        if(c == '|'){
            for(Boolean b: list){
                if(b) return true;
            }
            return false ;
        }
        else {
            for(Boolean b: list){
                if(!b) return false ;
            }
            return true ;
        }
    }
}