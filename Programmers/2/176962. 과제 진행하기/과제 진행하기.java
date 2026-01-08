import java.util.*;

class Solution {
    
    static class Task {
        String name;
        int start;
        int remaining;

        Task(String name, int start, int remaining) {
            this.name = name;
            this.start = start;
            this.remaining = remaining;
        }
    }

    private int toMinutes(String hhmm) {
        int hh = Integer.parseInt(hhmm.substring(0, 2));
        int mm = Integer.parseInt(hhmm.substring(3, 5));
        
        return hh * 60 + mm;
    }    
    
    public String[] solution(String[][] plans) {
        int n = plans.length;
        Task[] arr = new Task[n];

        for (int i = 0; i < n; i++) {
            String name = plans[i][0];
            int start = toMinutes(plans[i][1]);
            int play = Integer.parseInt(plans[i][2]);
            arr[i] = new Task(name, start, play);
        }

        Arrays.sort(arr, Comparator.comparingInt(t -> t.start));

        Deque<Task> stack = new ArrayDeque<>();
        List<String> done = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Task cur = arr[i];
            
            int curTime = cur.start;
            int nextStart = (i == n - 1) ? Integer.MAX_VALUE : arr[i + 1].start;

            int available = nextStart - curTime;

            if (cur.remaining <= available) {
                curTime += cur.remaining;
                done.add(cur.name);
                available -= cur.remaining;

                while (available > 0 && !stack.isEmpty()) {
                    Task top = stack.peekLast();
                    
                    if (top.remaining <= available) {
                        available -= top.remaining;
                        done.add(top.name);
                        stack.pollLast();
                    } else {
                        top.remaining -= available;
                        available = 0;
                    }
                }
            } else {
                cur.remaining -= available;
                stack.addLast(cur);
            }
        }

        while (!stack.isEmpty()) {
            done.add(stack.pollLast().name);
        }

        return done.toArray(new String[0]);
    }
}