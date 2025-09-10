// User function Template for Java

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
        for(int freq : map.values()){
            maxheap.add(freq);
        }

        int time = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        while(!maxheap.isEmpty()){
            for(int i=0;i<=n;i++){
                if(maxheap.isEmpty()){
                    // put remaining tasks back
                    for(int j=0;j<temp.size();j++){
                        if(temp.get(j) > 0){
                            maxheap.add(temp.get(j));
                        }
                    }
                    // only add idle time if heap still has tasks
                    if(!maxheap.isEmpty() && temp.size() <= n){
                        time += (n + 1 - temp.size());
                    }
                    break;
                }

                int curr = maxheap.poll();
                temp.add(curr - 1);
                time++;
            }

            for(int j=0;j<temp.size();j++){
                if(temp.get(j) > 0){
                    maxheap.add(temp.get(j));
                }
            }
            temp.clear();
        }

        return time;
    }
}
