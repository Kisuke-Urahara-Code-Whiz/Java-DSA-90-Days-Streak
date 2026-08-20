package LeetCodeEasy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        if(numRows==1) return result;
        result.add(List.of(1,1));
        if(numRows==2) return result;
        int height = 2;
        while(height<numRows){
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            int p1 = 0;
            int p2 = 1;
            while(p2<=(height-1)){
                row.add(result.get(height-1).get(p1++) + result.get(height-1).get(p2++));
            }
            row.add(1);
            result.add(row);
            height++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode118().generate(6));
    }

}
