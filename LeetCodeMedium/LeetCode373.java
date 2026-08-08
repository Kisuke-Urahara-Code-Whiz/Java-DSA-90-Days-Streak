package LeetCodeMedium;
import java.util.ArrayList;
import java.util.List;

public class LeetCode373 {

    static class Heap{

        int[] heap;
        int[][] pairs;
        int top;

        Heap(int size){
            this.heap = new int[size+1];
            this.pairs = new int[size+1][2];
            this.top = 1;
        }

        void swap(int p1, int p2){
            int temp = heap[p1];
            heap[p1] = heap[p2];
            heap[p2] = temp;

            int[] tempPair = pairs[p1];
            pairs[p1] = pairs[p2];
            pairs[p2] = tempPair;
        }

        void insert(int sum, int val1, int val2){
            heap[top] = sum;
            pairs[top] = new int[]{val1, val2};
            int index = top++;
            while(index!=1 && heap[index]<heap[index/2]){
                swap(index, index/2);
                index = index/2;
            }
        }

        int[] delete(){
            int[] result = pairs[1];
            swap(1, --top);
            int index = 1;

            while(2*index<top){
                int sIndex = 2*index;
                if(sIndex+1 < top && heap[sIndex+1]<heap[sIndex]) sIndex++;
                if(heap[sIndex]<heap[index]){
                    swap(index, sIndex);
                    index = sIndex;
                } else break;
            }

            return result;
        }


    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int min1 = Math.min(nums1.length, k);

        Heap heap = new Heap(min1);

        for(int i = 0; i < min1; i++){
            heap.insert(nums1[i] + nums2[0], i, 0);
        }


        while(k != 0 && heap.top > 1){
            int[] pairs = heap.delete();
            temp.add(nums1[pairs[0]]);
            temp.add(nums2[pairs[1]]);
            result.add(new ArrayList<>(temp));
            temp.removeLast();
            temp.removeLast();

            k--;

            if (pairs[1] + 1 < nums2.length) {
                heap.insert(nums1[pairs[0]] + nums2[pairs[1] + 1], pairs[0], pairs[1] + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode373().kSmallestPairs(
                new int[]{1,7,11},
                new int[]{2,4,6},
                3
        ));
    }

}
