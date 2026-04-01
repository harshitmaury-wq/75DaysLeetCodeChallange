class Solution {
    public int evalRPN(String[] t) {
        Stack<Integer> s = new Stack<>();
        int i=0;
        while(i<t.length){
            if(s.isEmpty()) s.push(Integer.parseInt(t[i]));
            else {
                if(s.size() >=2 && t[i].equals("+")){
                    int a = s.pop();
                    int b = s.pop();
                    s.push(a+b); 
                    i++;  continue;

                }
              else if(s.size() >=2 && t[i].equals("-")  ){
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b-a);
                   i++; continue;
                }
              else   if(s.size() >=2 &&  t[i].equals("*") ){
                    int a = s.pop();
                    int b = s.pop();
                    s.push(a*b);
                     i++; continue;

                }
             else if(s.size() >=2 && t[i].equals("/") ){
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b/a);
                    i++; continue;

                }
                else s.push(Integer.parseInt(t[i]));

            }
            i++;
        }
        return s.pop();
    }
}