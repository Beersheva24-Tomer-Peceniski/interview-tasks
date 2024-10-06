package telran.interview;

import java.util.Arrays;
import java.util.HashSet;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *         summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> hs = new HashSet<>();
        Arrays.stream(array).forEach(i -> hs.add(i));
        for(int e : array) {
            Integer key = sum - e;
            if(hs.contains(key)) {
                return true;
            }
        }
        return false;
    }
}