class NumArray {
    int[] num;
    int[] arr;
    public NumArray(int[] nums) {
        num = nums ;
        arr = new int[4*nums.length] ;
        build(0, num.length-1, 0) ;
    }
    void build(int s, int e, int i){
        if(s == e) {arr[i] = num[e] ; return  ;}

        int mid = s + (e - s) / 2;
        build(s, mid, 2*i+1) ;
        build(mid + 1, e, 2*i + 2) ;

        arr[i] = arr[2*i+1] + arr[2*i+2] ;
    }
    
    public void update(int index, int val) {
        up(0, num.length-1, index, 0, val) ;
    }
    void up (int s, int e , int idx, int i, int val ){
        
        if( s==e) {arr[i] = val; return; }

        int mid = s + (e - s) / 2 ;
        if(idx <= mid) up(s, mid, idx, 2*i+1, val ) ;
        
        else up(mid+1, e, idx, 2*i+2, val ) ;

        arr[i] = arr[2*i+1] + arr[2*i+2] ;

    }
    
    public int sumRange(int left, int right) {
        return sum(0, num.length-1, left, right, 0) ;
    }
    int sum (int s, int e , int l, int r, int i){
        
        if(r < s || l > e) return 0;
        if(l <= s && e <= r) {return arr[i];  }

        int mid = s + (e - s) / 2;

        return sum(s, mid, l, r, 2*i+1) +  sum(mid+1, e, l, r, 2*i+2) ;

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */