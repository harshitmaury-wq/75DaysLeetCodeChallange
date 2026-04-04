class Solution {
    public String decodeCiphertext(String et, int rows) {
        if(et.length()==0) return new String("");
        int z=0;
        int col = et.length()/rows;
        char[][] mat = new char[rows][col];
        for(int x=0; x<rows; x++){
            for(int y=0; y<col; y++){
                mat[x][y] = et.charAt(z);
                z++;
            }
        }
        
       
        StringBuilder dt = new StringBuilder();
        int up = 0;
        for(int j=0; j<col; j++){
            int r = 0;
            int c = j;
            while(r<rows && j<col){
                dt.append(mat[r][j]);
                j++;
                r++;
            }
            j=c;
        }
        int len = dt.length()-1;
        while(dt.charAt(len)==' ') {dt.setLength(dt.length()-1); len--;}
        return dt.toString();
    }
}