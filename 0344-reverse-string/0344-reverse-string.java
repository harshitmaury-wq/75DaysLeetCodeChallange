class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while(i<=j){
            swap(s, i,j);
            i++;j--;
        }
    }
    static void swap(char[] arr, int a, int b){
     char temp=arr[a];
      arr[a]=arr[b];
      arr[b] = temp;
    }
}