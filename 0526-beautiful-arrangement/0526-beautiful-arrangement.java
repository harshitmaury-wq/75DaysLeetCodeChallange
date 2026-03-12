class Solution {
    int sum = 0;
    public int countArrangement(int n) {
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        fun(arr, 0);
        return sum;
    }
     void fun(int[] arr, int s ){
        if(s==arr.length) {sum++; return;}

        for(int i = s; i< arr.length; i++){
            if(!(arr[i]%(s+1)==0 || (s+1)%arr[i]==0)) continue;
            swap(arr, s, i);
            fun(arr, s+1);
            swap(arr, s, i);

        }
    }
     void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}