class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals[0];

        int[][] result;
        int i = 0;
        int j = 1;
        int k = 0;

        while(j != i && j < intervals.length) {
            if(intervals[j][0] <= intervals[i][1] || intervals[i][0] >= intervals[j][1]) {
                result[k] = {Math.min(intervals[i][0], intervals[j][0]), Math.max(intervals[i][1], intervals[j][1])};
            }

        }



        
    }

    
}