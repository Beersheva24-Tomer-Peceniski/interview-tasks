package telran.interview;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        int[] array = {1, 2, 3, 7, 11, 13, 17, 23};
        assertTrue(InterviewTasks.hasSumTwo(array, 10));
        assertTrue(InterviewTasks.hasSumTwo(array, 40));
        assertFalse(InterviewTasks.hasSumTwo(array, 29));
        assertFalse(InterviewTasks.hasSumTwo(array, 100));
    }
}