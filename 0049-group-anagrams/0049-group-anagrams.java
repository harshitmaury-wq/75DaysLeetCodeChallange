    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String,ArrayList<String>> hm=new HashMap<>();
            List<List<String>> lis=new ArrayList<>();
            
            for(int i=0; i<strs.length;i++){
                
                char[] ch = strs[i].toCharArray();
                    Arrays.sort(ch);
                    String key = new String(ch);

                if(hm.containsKey(key)) hm.get(key).add(strs[i]);
                else{
                    hm.put(key,new ArrayList<>());
                    hm.get(key).add(strs[i]);
                }
            }
            for(String t: hm.keySet()){
                lis.add(hm.get(t));
            }
            return lis;
        }
    }