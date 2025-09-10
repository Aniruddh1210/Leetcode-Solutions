class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) return 0;

        // frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);

        // max heap of frequencies
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : map.values()) maxheap.add(f);

        int time = 0;

        while (!maxheap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int tasksExecuted = 0;

            // try to execute up to (n+1) tasks in this cycle
            for (int i = 0; i <= n; i++) {
                if (!maxheap.isEmpty()) {
                    int cnt = maxheap.poll();
                    tasksExecuted++;
                    if (cnt - 1 > 0) temp.add(cnt - 1);
                } else {
                    break;
                }
            }

            // put remaining counts back
            for (int v : temp) maxheap.add(v);

            // if heap is empty now, this was the last (partial) cycle: add only tasksExecuted
            // otherwise we used (n+1) time units for this full cycle
            if (maxheap.isEmpty()) time += tasksExecuted;
            else time += (n + 1);
        }

        return time;
    }
}
