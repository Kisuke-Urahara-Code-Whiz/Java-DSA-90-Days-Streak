package LeetCodeMedium;

public class LeetCode1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        boolean[] covered = new boolean[intervals.length];
        int remaining = intervals.length;
        for(int i=0;i<intervals.length;i++){
            if(covered[i]) continue;
            for(int j=i+1;j<intervals.length;j++){
                if(covered[j]) continue;
                if(cover(intervals[i][0], intervals[j][0], intervals[i][1], intervals[j][1])){
                    remaining--;
                    covered[i] = true;
                    break;
                } else if(cover(intervals[j][0], intervals[i][0], intervals[j][1], intervals[i][1])){
                    remaining--;
                    covered[j] = true;
                }
            }
        }
        return remaining;
    }

    public boolean cover(int s1, int s2, int e1, int e2){
        return s1>=s2 && e2>=e1;
    }

}
