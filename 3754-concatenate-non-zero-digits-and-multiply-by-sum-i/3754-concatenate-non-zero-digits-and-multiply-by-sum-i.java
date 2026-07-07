class Solution {
    public long sumAndMultiply(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        int sum=0;
        int rem;
        long ans=0; int a=1;
        while(n!=0){
            rem=n%10;
            sum+=rem;
            n=n/10;
            if(rem!=0) list.add(rem);
        }
        if(list.isEmpty()) return ans;
        
        
        for(int i=0; i<list.size();i++){
            ans=list.get(i)*a+ans;
            a=a*10;
        }
        ans=ans*sum;
        return ans;
    }
}