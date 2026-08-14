class Node{
    int maxlen;
    int pre;
    int suf;
    char start;
    char end ;
    Node(int len, int p, int s, char st, char en){
        this.maxlen = len;
        this.pre = p;
        this.suf = s;
        this.start = st;
        this.end = en ;
    }

}
class Solution {
    public int[] longestRepeating(String s, String q, int[] qi) {
        Node[] seg = new Node[4*s.length()] ;
        build(seg, s, 0, s.length()-1, 0) ;

        int[] ans = new int[qi.length] ;
        for(int i = 0; i<qi.length; i++) {
            update(seg, 0, s.length()-1, q.charAt(i), 0, qi[i]) ;
            ans[i] = seg[0].maxlen ;
        }

        return ans ;
    }
void build (Node[] seg, String s, int st, int e, int i) {
    if(st == e) {
        seg[i] = new Node(1, 1, 1, s.charAt(st), s.charAt(st)) ;
        return ;
    }
    int mid = st + (e - st) / 2 ;

    build(seg, s, st, mid, 2*i+1) ;
    build(seg, s, mid+1, e, 2*i+2) ;

    int currlen = Math.max(seg[2*i+1].maxlen, seg[2*i+2].maxlen) ;
    if( seg[2*i+1].end == seg[2*i+2].start ) 
    currlen = Math.max(currlen, seg[2*i+1].suf + seg[2*i+2].pre) ;


    int currpre = seg[2*i+1].pre ;
    int currsuf = seg[2*i+2].suf ;

    if(seg[2*i+1].suf == mid-st+1 && seg[2*i+1].end == seg[2*i+2].start) 
    currpre = seg[2*i+1].suf + seg[2*i+2].pre ;

    if(seg[2*i+2].pre == e-mid && seg[2*i+1].end == seg[2*i+2].start) 
    currsuf = seg[2*i+1].suf + seg[2*i+2].pre ;

    seg[i] = new Node (currlen, currpre, currsuf, seg[2*i+1].start, seg[2*i+2].end) ;

}

void update (Node[] seg, int s, int e, char t, int i, int ti) {
    if(s==e) {
        seg[i] = new Node(1, 1, 1, t, t) ;
        return ;
    }

    int mid = s + (e - s) / 2 ;

    if(ti <= mid) update(seg, s, mid, t, 2*i+1, ti) ;
    else update(seg, mid+1, e, t, 2*i+2, ti) ;

     int currlen = Math.max(seg[2*i+1].maxlen, seg[2*i+2].maxlen) ;
    if( seg[2*i+1].end == seg[2*i+2].start ) 
    currlen = Math.max(currlen, seg[2*i+1].suf + seg[2*i+2].pre) ;


    int currpre = seg[2*i+1].pre ;
    int currsuf = seg[2*i+2].suf ;

    if(seg[2*i+1].suf == mid-s+1 && seg[2*i+1].end == seg[2*i+2].start) 
    currpre = seg[2*i+1].suf + seg[2*i+2].pre ;

    if(seg[2*i+2].pre == e -mid && seg[2*i+1].end == seg[2*i+2].start) 
    currsuf = seg[2*i+1].suf + seg[2*i+2].pre ;

    seg[i] = new Node (currlen, currpre, currsuf, seg[2*i+1].start, seg[2*i+2].end) ;
}
}