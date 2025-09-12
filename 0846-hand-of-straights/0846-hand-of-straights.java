class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        PriorityQueue<Integer> Minheap = new PriorityQueue<>();
        for (int i : nums) {
            Minheap.add(i);
        }

        while (!Minheap.isEmpty()) {
            int temp = Minheap.poll();   
            ArrayList<Integer> list = new ArrayList<>();

            
            for (int i = 1; i < k; i++) {
                while (!Minheap.isEmpty() && Minheap.peek() == temp) {
                    list.add(Minheap.poll());
                }

                if (Minheap.isEmpty()) {
                    return false; // not enough numbers
                }
                
                if (Minheap.peek() != temp + 1) {
                    return false; 
                }

                temp = Minheap.poll();
            }

            for (int val : list) {
                Minheap.add(val);
            }
        }

        return true;       
    }
}