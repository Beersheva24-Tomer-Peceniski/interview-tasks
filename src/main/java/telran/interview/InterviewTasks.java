package telran.interview;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public class InterviewTasks {
    static public boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> helpers = new HashSet<>();
        int index = 0;
        while (index < array.length && !helpers.contains(sum - array[index])) {
            helpers.add(array[index++]);
        }
        return index < array.length;
    }

    static public int getMaxWithNegativePresentation(int[] array) {
        HashSet<Integer> hs = new HashSet<>();
        int res = -1;
        for (int number : array) {
            hs.add(number);
            if ((hs.contains(-number)) & (Math.abs(number) > res)) {
                res = Math.abs(number);
            }
        }
        return res;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        // TODO
        // rolesHistory is the list containg dates and roles assigned to the employees
        // at the appropriate dates
        // for example, date => 2019-01-01, role => Developer means that some employee
        // (no matter who) was taken
        // role Developer at 2019-01-01
        // create List<DateRole> with roles matching with the given dates
        // most effective data structure
        throw new UnsupportedOperationException();
    }

    public static boolean isAnagram(String word, String anagram) {
        if (word.compareTo(anagram) == 0) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            String safe = anagram;
            anagram = anagram.replaceFirst(String.valueOf(word.charAt(i)), "");
            if (anagram.compareTo(safe) == 0) {
                return false;
            }
        }
        return true;
    }

}