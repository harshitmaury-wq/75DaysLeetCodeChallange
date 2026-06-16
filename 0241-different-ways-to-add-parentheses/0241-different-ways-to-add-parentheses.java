class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return fun(expression, 0, expression.length()-1 ) ;
    }
    List<Integer> fun(String exp, int s, int e){


        List<Integer> ans = new ArrayList<>() ;
        for(int i = s; i<=e ; i++) {
            if(exp.charAt(i)=='*' || exp.charAt(i)=='+' || exp.charAt(i)=='-'){
                List<Integer> left = fun(exp, s, i -1 ) ;
                List<Integer> right = fun(exp, i+1, e) ;
            
            for(int x = 0; x<left.size(); x++){
                for(int y = 0; y<right.size(); y++){
                    if(exp.charAt(i) == '+') ans.add(left.get(x) + right.get(y)) ;
                    else if(exp.charAt(i) == '*') ans.add(left.get(x) * right.get(y)) ;
                    else if(exp.charAt(i) == '-') ans.add(left.get(x) - right.get(y)) ;
                }
            }
            }
        }
        if(ans.size() == 0) ans.add(Integer.parseInt(exp.substring(s, e+1))) ;
        return ans ;
    }
}