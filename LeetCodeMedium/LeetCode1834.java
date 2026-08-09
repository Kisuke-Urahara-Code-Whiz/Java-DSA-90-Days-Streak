package LeetCodeMedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode1834 {

    static class Task {
        int enqueueTime;
        int processingTime;
        int index;

        Task(int a, int b, int c) {
            enqueueTime = a;
            processingTime = b;
            index = c;
        }
    }

    public int[] getOrder(int[][] tasks) {

        Task[] arr = new Task[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            arr[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.enqueueTime));

        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> {
            if (t1.processingTime != t2.processingTime) {
                return Integer.compare(t1.processingTime, t2.processingTime);
            }
            return Integer.compare(t1.index, t2.index); });

        int[] result = new int[tasks.length];
        int resultIndex = 0;
        int taskIndex = 0;
        long time = 0;

        while (resultIndex < tasks.length) {

            if (pq.isEmpty() && time < arr[taskIndex].enqueueTime) {
                time = arr[taskIndex].enqueueTime;
            }

            while (taskIndex < tasks.length && arr[taskIndex].enqueueTime <= time) {
                pq.add(arr[taskIndex]);
                taskIndex++;
            }

            Task current = pq.poll();
            time += current.processingTime;
            result[resultIndex++] = current.index;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode1834().getOrder(new int[][]{
                {1, 9}, {2, 4}, {3, 2}, {1, 2}
        })));
    }
}