// https://leetcode.com/problems/maximum-distance-in-arrays/description/
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // 1, 2, 3, 4, 5
        // max in 5, min in 3, or min in 5, max somewhere else
        // the max and min cant be in two different arrays from the ones chosen because the algorithm would've chose those

        // min in 5, max in 3 can be chosen
        // ex:
        // 5: -20,1,2,3,4,10
        // 3: 0,1,2,3,4,5
        // 2: 1,2,3,4,5,6,7

        // Just need to check min in 5 max somewhere else (including 3)
        // Do you need to check max in 3, min somewhere else (excluding 5)
        //      No because the original algorithm would have chosen max in 5, min somewhere else
        //      since max in 5 greater than max in 3

        // Duplicate maxes:
        // 5: -20,1,2,3,4,10
        // 3: 0,1,2,3,4,5
        // 2: 0,1,2,3,4,5,10
        int maxValueArr = 0;
        // Search for max
        for(int i=1; i<arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            List<Integer> prev = arrays.get(maxValueArr);
            if(curr.get(curr.size()-1) > prev.get(prev.size()-1)) maxValueArr = i;
        }
        // Search for min
        int minValueArr = -1;
        for(int i=0; i<arrays.size(); i++) {
            if(i != maxValueArr) {
                if(minValueArr == -1) minValueArr = i; 
                else {
                    List<Integer> curr = arrays.get(i);
                    List<Integer> prev = arrays.get(minValueArr);
                    if(curr.get(0) < prev.get(0)) minValueArr = i;
                }
            }
        }
        // Search for secondary max
        int secondMaxArr = -1;
        for(int i=0; i<arrays.size(); i++) {
            if(i != maxValueArr) {
                if(secondMaxArr == -1) secondMaxArr = i;
                else {
                    List<Integer> curr = arrays.get(i);
                    List<Integer> prev = arrays.get(secondMaxArr);
                    if(curr.get(curr.size()-1) > prev.get(prev.size()-1)) secondMaxArr = i;
                }
            }
        }
        int maxValue1 = arrays.get(maxValueArr).get(arrays.get(maxValueArr).size()-1);
        int minValue1 = arrays.get(minValueArr).get(0);
        int maxValue2 = arrays.get(secondMaxArr).get(arrays.get(secondMaxArr).size()-1);
        int minValue2 = arrays.get(maxValueArr).get(0);
        return Math.max(maxValue1 - minValue1, maxValue2 - minValue2);
    }
}
