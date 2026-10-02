class Solution {
    public List<String> generateParenthesis(int n) {


         ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
       Gen(n, 0, 0, list, sb);
        return list;
        
    }
     static void Gen(int n, int l, int r, ArrayList<String> list, StringBuilder sb){
        
        if(l+r==2*n) {list.add(sb.toString()); return;}
        
        else{

            if(l<n) {
                sb.append('(');
                Gen(n, l+1, r, list, sb);
                sb.setLength(sb.length()-1);
            }
              if(l>r) {
                sb.append(')');
                Gen(n, l, r+1, list, sb);
                sb.setLength(sb.length()-1);
            }
                
            

        }

    }
}