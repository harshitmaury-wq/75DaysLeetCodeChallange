class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int m;
        ArrayList<Character> list = new ArrayList<>();
      
        int[] map = new int[26];
        for(int i=0; i<tasks.length; i++) map[tasks[i]-'A']++;

          PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> {
            if(map[a-'A'] < map[b-'A']) return 1;
            else if(map[a-'A'] > map[b-'A']) return -1;
            else return 0;
        });

        for(int i=0; i<26; i++) {
            if(map[i] != 0) pq.add((char)('A' + i));
        }

        while(!pq.isEmpty()){
            time++;
            map[pq.peek()-'A']--;
            if(map[pq.peek()-'A'] != 0) list.add(pq.remove());
            else pq.remove();
            m = n;
            while(m>0){
                if(pq.isEmpty() && list.size()==0) return time;
                time++;
                m--;
                if(!pq.isEmpty()) { 
                map[pq.peek()-'A']--; 
                if(map[pq.peek()-'A'] != 0)  list.add(pq.remove());
                else pq.remove();

                 }

                
               
            }
           for(Character c : list) {
            if(map[c-'A'] != 0) pq.add(c);
           }
            list.clear();
        }
        return time;
    }
}